package com.github.hkokocin.atheris.interactor

import com.github.hkokocin.atheris.interactor.Interactor
import com.github.hkokocin.atheris.router.FragmentRouter

interface FragmentInteractor : Interactor {
    override val router: FragmentRouter
}