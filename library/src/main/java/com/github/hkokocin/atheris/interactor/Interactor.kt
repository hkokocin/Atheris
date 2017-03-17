package com.github.hkokocin.atheris.interactor

import com.github.hkokocin.atheris.Presenter
import com.github.hkokocin.atheris.router.Router

interface Interactor {
    val presenter: Presenter
    val router: Router
}