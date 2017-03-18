package com.github.hkokocin.atheris.router

import android.app.Activity
import com.github.hkokocin.atheris.android.ActivityLifecycle
import com.github.hkokocin.atheris.router.Router
import kotlin.reflect.KClass

open class ActivityRouter(private val activity: Activity) : Router(activity) {
    open val lifecycle = ActivityLifecycle()

    fun hasExtra(name: String) = activity.intent.hasExtra(name)

    inline fun <reified T : Any> getExtra(name: String) = getExtra(T::class, name)
    inline fun <reified T : Any> getExtra(name: String, default: T) = getExtra(T::class, name) ?: default
    fun <T : Any> getExtra(type: KClass<T>, name: String) = com.github.hkokocin.androidkit.app.getExtra(type,
            name,
            activity.intent)
}