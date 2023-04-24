package com.trdz.motion.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.trdz.motion.model.Repository
import com.trdz.motion.model.RepositoryExecutor

class ViewModelFactories(
	private val dataLive: SingleLiveData<StatusProcess> = SingleLiveData(),
	private val repository: Repository = RepositoryExecutor(),
): ViewModelProvider.Factory {

	@Suppress("UNCHECKED_CAST")
	override fun <T: ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
		MainViewModel::class.java -> MainViewModel(dataLive,repository)
		else -> throw IllegalArgumentException("Unknown ViewModel class")
	} as T

}