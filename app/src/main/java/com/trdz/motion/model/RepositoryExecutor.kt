package com.trdz.motion.model

import android.util.Log
import io.reactivex.rxjava3.core.Single

class RepositoryExecutor: Repository {
	/** Отправка запроса NASA EpicPicture,MarsRoverPicture,PictureOfTheDay */
	override fun connection(prefix: String, date: String?): Single<RequestResult> {
		Log.d("@@@", "Rep - start connection $prefix on date: $date")
		val externalSource: ExternalSource = ServerFirebase()
		return Single.create{
			val data = externalSource.load(date).copy(prefix = prefix)
			it.onSuccess(data)
		}
	}

}
