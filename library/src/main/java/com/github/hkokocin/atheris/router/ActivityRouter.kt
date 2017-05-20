package com.github.hkokocin.atheris.router

import android.app.Activity
import android.app.AlertDialog
import com.github.hkokocin.androidkit.content.alertDialog
import com.github.hkokocin.atheris.android.ActivityLifecycle

open class ActivityRouter(private val activity: Activity) : Router(activity) {
    open val lifecycle = ActivityLifecycle()

    fun alertDialog(init: AlertDialog.Builder.() -> Unit) {
        activity.alertDialog(init)
    }
}