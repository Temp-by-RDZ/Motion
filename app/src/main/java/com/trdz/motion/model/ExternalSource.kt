package com.trdz.motion.model

/** Интерфейс для Источников Данных */
interface ExternalSource {
	fun load(date: String?): RequestResult
}