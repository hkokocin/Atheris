package com.github.hkokocin.atheris.router

import android.app.Activity
import android.content.res.Resources
import android.support.v7.app.AppCompatActivity
import com.github.hkokocin.androidkit.app.getExtra
import com.github.hkokocin.androidkit.app.getResource
import com.github.hkokocin.androidkit.content.getColorInt
import kotlin.reflect.KClass

open class Router(
        private val activity: Activity
) {

    val packageName: String = activity.packageName

    fun finishActivity() = activity.finish()

    // ==============================================================================
    // Actionbar
    // ==============================================================================

    fun setTitle(title: String) {
        activity.actionBar?.title = title
        if (activity is AppCompatActivity)
            activity.supportActionBar?.title = title
    }

    fun setSubTitle(subtitle: String) {
        activity.actionBar?.subtitle = subtitle
        if (activity is AppCompatActivity)
            activity.supportActionBar?.subtitle = subtitle
    }

    fun showUpButton(show: Boolean) {
        activity.actionBar?.setDisplayHomeAsUpEnabled(show)
        activity.actionBar?.setHomeButtonEnabled(show)

        if (activity is AppCompatActivity) {
            activity.supportActionBar?.setDisplayHomeAsUpEnabled(show)
            activity.supportActionBar?.setHomeButtonEnabled(show)
        }
    }

    // ==============================================================================
    // Resources
    // ==============================================================================

    val resources: Resources
        get() = activity.resources

    fun hasExtra(name: String) = activity.intent.hasExtra(name)
    inline fun <reified T : Any> getExtra(name: String, default: T) = getExtra(name, default, T::class)
    fun <T : Any> getExtra(name: String, default: T, type: KClass<T>) = getExtra(activity.intent, name, type) ?: default
    inline fun <reified T : Any> getExtra(name: String) = getExtra(name, T::class)
    fun <T : Any> getExtra(name: String, type: KClass<T>) = getExtra(activity.intent, name, type)

    inline fun <reified T : Any> getResource(resourcesId: Int) = getResource(resourcesId, T::class)
    fun <T : Any> getResource(resourcesId: Int, type: KClass<T>) = getResource(resources, resourcesId, type)

    fun getColorResource(resourcesId: Int, theme: Resources.Theme? = null) = resources.getColorInt(resourcesId, theme)

    fun getDimensionInPixels(resourcesId: Int) = resources.getDimensionPixelSize(resourcesId)
}