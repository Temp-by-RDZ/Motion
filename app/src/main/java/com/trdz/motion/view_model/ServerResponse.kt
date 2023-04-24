package com.trdz.motion.view_model

import com.trdz.motion.model.RequestResult

/** Ожидаемые действия VM на обращения */
interface ServerResponse {
	fun success(data: RequestResult)
	fun fail(prefix: String, code: Int, throwable: Throwable?)
}