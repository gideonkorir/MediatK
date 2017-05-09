package com.korir.mediatk

import kotlin.reflect.full.*
import kotlin.reflect.*
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.Deferred

interface Mediator {
	suspend fun <TRequest, TResponse> send(request: TRequest) : TResponse
		where TRequest : Request<TResponse>
	
	suspend fun <TNotification : Notification> publish(notification: TNotification) : Unit
}