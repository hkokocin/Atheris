package com.github.hkokocin.atheris.android

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hkokocin.atheris.interactor.DialogFragmentInteractor

abstract class ViperDialogFragment : DialogFragment() {

    abstract val interactor: DialogFragmentInteractor
    abstract val layout: Int

    lateinit var lifecycle: FragmentLifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        interactor.router.dialog = this
        lifecycle = interactor.router.lifecycle
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(layout, container).apply {
                interactor.presenter.create(this)
            }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycle.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        lifecycle.onStart()
    }

    override fun onResume() {
        super.onResume()
        lifecycle.onResume()
    }

    override fun onPause() {
        super.onPause()
        lifecycle.onPause()
    }

    override fun onStop() {
        super.onStop()
        lifecycle.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        lifecycle.onSaveInstanceState(outState)
    }
}