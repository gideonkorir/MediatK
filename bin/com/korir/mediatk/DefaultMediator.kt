package com.korir.mediatk
import kotlin.reflect.full.*
import kotlin.reflect.*
import kotlinx.coroutines.experimental.*

class DefaultMediator(val factory:HandlerFactory) : Mediator {

	override suspend fun <TRequest, TResponse> send(request: TRequest): TResponse
		where TRequest : Request<TResponse>{
		val handler = factory.getRequestHandler(request);
		return handler.handle(request)
	}
	
	override suspend fun <TNotification: Notification> publish(notification: TNotification) : Unit {
		//val type = notification::class.createType()
		factory.getNotificationHandlers(notification)
			.filterNotNull()
			.map { f ->	f.handle(notification)}
			.forEach { it.join() }		
	}
}