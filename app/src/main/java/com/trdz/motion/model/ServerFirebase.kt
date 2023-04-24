package com.trdz.motion.model

/** Получение данных*/
class ServerFirebase: ExternalSource {

	override fun load(date: String?): RequestResult {
		return RequestResult(1)
	}

}
