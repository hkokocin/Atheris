package com.github.hkokocin.atheris.android

class ViewLifecycle {
    var onAttachedToWindow: () -> Unit = {}
    var onDetachedFromWindow: () -> Unit = {}
    var onViewCreated: () -> Unit = {}
}