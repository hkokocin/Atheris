package com.github.hkokocin.atheris.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hkokocin.androidkit.view.onAttachedToWindow
import com.github.hkokocin.androidkit.view.onDetachedFromWindow
import com.github.hkokocin.atheris.interactor.ViewInteractor

abstract class ViperView {

    abstract val interactor: ViewInteractor
    abstract val layout: Int

    internal lateinit var lifecycle: ViewLifecycle

    var root: View? = null
        private set

    @Suppress("UNCHECKED_CAST")
    fun createView(inflater: LayoutInflater, parent: ViewGroup? = null, attachToParent: Boolean = false) {
        if (root != null) throw IllegalStateException("View has already been inflated")

        root = inflater.inflate(layout, parent, attachToParent).apply {
            interactor.presenter.create(this)
            onAttachedToWindow { lifecycle.onAttachedToWindow() }
            onDetachedFromWindow { lifecycle.onDetachedFromWindow() }
        }

        onViewCreated()
    }

    private fun onViewCreated() {
        lifecycle = interactor.router.lifecycle
        lifecycle.onViewCreated()
    }
}