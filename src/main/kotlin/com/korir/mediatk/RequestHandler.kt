package com.korir.mediatk

import kotlinx.coroutines.experimental.Deferred

//Represents an object that is able to handle/process
//a request in asynchronous manner
interface RequestHandler<in TRequest, out TResponse>
	where TRequest : Request<TResponse>{
	suspend fun handle(request: TRequest) : TResponse
}