package com.korir.mediatk.pipeline

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.CommonPool
import com.korir.mediatk.PipelineBehavior


class RequestPreProcessorBehavior<TRequest, TResponse>(private val processors:List<RequestPreProcessor<TRequest>>) : PipelineBehavior<TRequest, TResponse> {
	override suspend fun handle(req: TRequest, next: suspend () -> TResponse) : TResponse{
		processors.map{
			launch(CommonPool){
				it.process(req)
			}
		}.forEach({ it.join() })
		return next()
	}
}