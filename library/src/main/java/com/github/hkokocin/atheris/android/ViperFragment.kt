package com.github.hkokocin.atheris.android

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.hkokocin.atheris.interactor.FragmentInteractor

abstract class ViperFragment() : Fragment() {

    abstract val interactor: FragmentInteractor
    abstract val layout: Int
    open val attachToRoot: Boolean = true

    lateinit var lifecycle: FragmentLifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        lifecycle = interactor.router.lifecycle
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if (activity is ViperActivity) {
            val viperActivity = activity as ViperActivity
            viperActivity.lifecycle.onOptionsItemSelected = { lifecycle.onOptionsItemSelected(it) }
        }

        return inflater.inflate(layout, container, attachToRoot).apply {
            interactor.presenter.create(this)
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
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

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        lifecycle.onSaveInstanceState(outState)
    }
}
