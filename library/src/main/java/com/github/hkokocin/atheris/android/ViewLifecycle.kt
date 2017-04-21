package com.github.hkokocin.atheris.android

class ViewLifecycle {
    val onAttachedToWindow: () -> Unit = {}
    val onDetachedFromWindow: () -> Unit = {}
    val onViewCreated: () -> Unit = {}
}