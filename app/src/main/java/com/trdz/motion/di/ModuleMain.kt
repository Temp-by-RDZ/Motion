package com.trdz.motion.di

import com.trdz.motion.R
import com.trdz.motion.view.Navigation
import org.koin.dsl.module

val moduleMain = module {
	single<Navigation>() { Navigation(R.id.container_fragment_base) }
}


