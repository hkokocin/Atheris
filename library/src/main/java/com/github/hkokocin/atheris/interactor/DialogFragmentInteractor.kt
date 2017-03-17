package com.github.hkokocin.atheris.interactor

import com.github.hkokocin.atheris.interactor.Interactor
import com.github.hkokocin.atheris.router.DialogFragmentRouter

interface DialogFragmentInteractor : Interactor {
    override val router: DialogFragmentRouter

}