package com.korir.mediatk.pipeline

import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.CommonPool

import com.korir.mediatk.PipelineBehavior

class RequestPostProcessorBehavior<TRequest, TResponse>(private val processors: List<RequestPostProcessor<TRequest, TResponse>>) : PipelineBehavior<TRequest, TResponse> {	
	
	override suspend fun handle(req: TRequest, next: suspend () -> TResponse) : TResponse {
		val resp = next()
		processors.map({
			launch(CommonPool) {
				it.process(req, resp)
			}
		}).forEach({ it.join() })
		return resp		
	}
}