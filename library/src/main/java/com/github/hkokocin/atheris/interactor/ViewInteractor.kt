package com.github.hkokocin.atheris.interactor

import com.github.hkokocin.atheris.router.ViewRouter

interface ViewInteractor : Interactor {
    override val router: ViewRouter
}