package com.github.hkokocin.atheris

import android.content.Context
import android.view.View
import com.github.hkokocin.androidkit.content.getColorInt
import kotlin.reflect.KClass

abstract class Presenter {

    protected lateinit var context: Context
        private set

    protected lateinit var rootView: View
        private set

    var viewCreated: Boolean = false
        private set

    protected open fun onViewCreated() {}

    @Suppress("UNCHECKED_CAST")
    protected fun <T : View> viewId(resourcesId: Int) = lazy { rootView.findViewById(resourcesId) as T }

    protected inline fun <reified T : Any> resource(resourcesId: Int) = lazy {
        getResource(T::class, resourcesId)
    }

    protected inline fun <reified T : Any> getResource(resourcesId: Int) = getResource(T::class, resourcesId)

    fun <T : Any> getResource(type: KClass<T>, resourcesId: Int): T {
        return com.github.hkokocin.androidkit.app.getResource(
                context.resources,
                resourcesId,
                type)
    }

    @Suppress("UNCHECKED_CAST")
    protected fun colorResource(resourcesId: Int) = lazy {
        context.resources.getColorInt(resourcesId)
    }

    @Suppress("UNCHECKED_CAST")
    protected fun dimensionInPixels(resourcesId: Int) = lazy {
        context.resources.getDimensionPixelSize(resourcesId)
    }

    fun create(view: View) {

        if (viewCreated) throw IllegalStateException("View has already been created.")

        rootView = view
        context = view.context
        viewCreated = true
        onViewCreated()
    }
}