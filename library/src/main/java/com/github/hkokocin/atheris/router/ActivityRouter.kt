package com.github.hkokocin.atheris.router

import android.app.Activity
import com.github.hkokocin.atheris.android.ActivityLifecycle
import com.github.hkokocin.atheris.router.Router
import kotlin.reflect.KClass

open class ActivityRouter(private val activity: Activity) : Router(activity) {
    open val lifecycle = ActivityLifecycle()
}