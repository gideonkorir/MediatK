package com.korir.mediatk.pipeline

interface RequestPreProcessor<in TRequest> {
	suspend fun process(request: TRequest) : Unit
}