package com.trdz.motion.model

import io.reactivex.rxjava3.core.Single

/** Интерфейс для основного репозитория */
interface Repository {
	fun connection(prefix: String, date: String?) : Single<RequestResult>
}