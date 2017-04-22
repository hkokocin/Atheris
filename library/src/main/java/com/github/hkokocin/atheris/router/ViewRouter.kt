package com.github.hkokocin.atheris.router

import android.app.Activity
import com.github.hkokocin.atheris.android.ViewLifecycle

open class ViewRouter(activity: Activity) : Router(activity) {
    val lifecycle = ViewLifecycle()
}