package com.trdz.motion.di

import com.trdz.motion.model.Repository
import com.trdz.motion.model.RepositoryExecutor
import com.trdz.motion.view_model.SingleLiveData
import com.trdz.motion.view_model.StatusProcess
import com.trdz.motion.view_model.ViewModelFactories
import org.koin.dsl.module

val moduleViewModel = module {
	single<Repository>() {
		RepositoryExecutor()
	}
	factory<SingleLiveData<StatusProcess>>() { SingleLiveData() }
	single<ViewModelFactories>() {
		ViewModelFactories(
			dataLive = get(),
			repository = get(),
		)
	}
}


