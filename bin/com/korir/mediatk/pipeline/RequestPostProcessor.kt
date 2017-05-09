package com.korir.mediatk.pipeline

interface RequestPostProcessor<in TRequest, in TResponse>{
	suspend fun process(req: TRequest, resp: TResponse) : Unit
}
