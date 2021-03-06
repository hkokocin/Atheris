package com.github.hkokocin.atheris.android

import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.github.hkokocin.atheris.interactor.ActivityInteractor

abstract class ViperActivity : AppCompatActivity() {

    protected abstract val interactor: ActivityInteractor
    protected abstract val layout: Int

    internal lateinit var lifecycle: ActivityLifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle = interactor.router.lifecycle
        lifecycle.onCreate(savedInstanceState)

        val rootView = layoutInflater.inflate(layout, null)
        setContentView(rootView)
        interactor.presenter.create(rootView)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        lifecycle.onPostCreate(savedInstanceState)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        lifecycle.onConfigurationChanged(newConfig)
    }

    override fun onStart() {
        super.onStart()
        lifecycle.onStart()
    }

    override fun onResume() {
        super.onResume()
        lifecycle.onResume()
    }

    override fun onPostResume() {
        super.onPostResume()
        lifecycle.onPostResume()
    }

    override fun onPause() {
        super.onPause()
        lifecycle.onPause()
    }

    override fun onStop() {
        super.onStop()
        lifecycle.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        lifecycle.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycle.onDestroy()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        lifecycle.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            if (lifecycle.onOptionsItemSelected(item))
                true
            else
                super.onOptionsItemSelected(item)
}