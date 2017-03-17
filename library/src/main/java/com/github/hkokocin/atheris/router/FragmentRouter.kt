package com.github.hkokocin.atheris.router

import android.app.Activity
import com.github.hkokocin.atheris.router.Router
import com.github.hkokocin.atheris.android.FragmentLifecycle

open class FragmentRouter(activity: Activity) : Router(activity) {
    val lifecycle = FragmentLifecycle()
}