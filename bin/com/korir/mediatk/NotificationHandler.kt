package com.korir.mediatk
import kotlinx.coroutines.experimental.Job

//handles notifications asynchronously
interface NotificationHandler<in TNotification:Notification>{
	suspend fun handle(notification: TNotification) : Job
}