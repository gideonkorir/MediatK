package com.korir.mediatk

import kotlin.reflect.KType

interface HandlerFactory {
	fun <TRequest, TResponse> getRequestHandler(request: TRequest) : RequestHandler<TRequest, TResponse>
		where TRequest : Request<TResponse>
	
	fun <TNotification> getNotificationHandlers (notification: TNotification) : List<NotificationHandler<TNotification>>
			where TNotification : Notification
}