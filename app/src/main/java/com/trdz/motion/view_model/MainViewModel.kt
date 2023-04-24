package com.trdz.motion.view_model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.trdz.motion.model.Repository
import com.trdz.motion.model.RepositoryExecutor
import com.trdz.motion.model.RequestResult
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import java.text.SimpleDateFormat
import java.util.*

/** Главная VM для сегмента Picture */
class MainViewModel(
	private val dataLive: SingleLiveData<StatusProcess> = SingleLiveData(),
	private val repository: Repository = RepositoryExecutor(),
): ViewModel(), ServerResponse {


	fun getData(): LiveData<StatusProcess> = dataLive

	/** Подготовка запроса*/
	fun initialize(prefix: String) {

	}

	/** Работа с датой для запроса */
	private fun getData(change: Int): String {
		val calendar = Calendar.getInstance()
		calendar.add(Calendar.DATE, change)
		val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
		return dateFormat.format(calendar.time)
	}

	/** Выполнение запроса */
	private fun request(prefix: String, date: String?) {
		repository.connection(prefix, date)
			.subscribeOn(Schedulers.io())
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(
				{
					if (it.code in 200..299) {
						success(it)
					}
					else {
						fail(it.prefix,it.code,Throwable(it.description))
					}
				},
				{ exception -> fail(prefix,-4, exception) })
	}

	/** Реакция MV на успех запроса */
	override fun success(data: RequestResult) {
		Log.d("@@@", "Mod - get success ${data.prefix} answer")
		dataLive.postValue(StatusProcess.Success(data))
	}

	/** Реакция MV на ошибку запроса */
	override fun fail(prefix: String, code: Int, throwable: Throwable?) {
		Log.d("@@@", "Mod - request $prefix failed $code")
		val message = throwable ?: Throwable("Unspecified Error")
		dataLive.postValue(StatusProcess.Error(code, message))
	}
}