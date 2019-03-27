package com.fxy.lib.utils.extensions

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

/**
 * create by:Fxymine4ever
 * time: 2019/3/27
 */
inline fun <T> LiveData<T>.observe(owner: LifecycleOwner,crossinline onChange:(T?)->Unit) = observe(owner, Observer { onChange(it) })
inline fun <T> LiveData<T>.observeNotNull(owner: LifecycleOwner,crossinline onChange:(T?)->Unit) = observe(owner, Observer {
    it?:return@Observer
    onChange(it)
})