package com.korir.mediatk

import kotlin.reflect.KType

//marker interface for commands that should be
//processed synchronously
interface Request<out TResponse>{
}
