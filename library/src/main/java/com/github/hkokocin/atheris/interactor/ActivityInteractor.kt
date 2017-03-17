package com.github.hkokocin.atheris.interactor

import com.github.hkokocin.atheris.android.ActivityLifecycle
import com.github.hkokocin.atheris.router.ActivityRouter
import com.github.hkokocin.atheris.router.Router
import com.github.hkokocin.atheris.interactor.Interactor

interface ActivityInteractor : Interactor {
    override val router: ActivityRouter
}