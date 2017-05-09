package com.korir.mediatk

interface PipelineBehavior<in TRequest, TResponse>{
	suspend fun handle(request: TRequest, next: suspend () -> TResponse) : TResponse
}
