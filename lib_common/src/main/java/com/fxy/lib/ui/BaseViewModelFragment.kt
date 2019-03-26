package com.fxy.lib.ui

import android.arch.lifecycle.*
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
abstract class BaseViewModelFragment<T : ViewModel> : Fragment() {
    protected lateinit var model:T
    protected abstract var modelClass:Class<T>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var modelFactory = getViewModelFactory()
        if(modelFactory == null){
            model = ViewModelProviders.of(this).get(modelClass)
        }else{
            model = ViewModelProviders.of(this,modelFactory).get(modelClass)
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected fun getViewModelFactory(): ViewModelProvider.Factory? = null

    inline fun <T> LiveData<T>.observe(crossinline onChange:(T?)->Unit) = observe(this@BaseViewModelFragment, Observer { onChange(it) })
    inline fun <T> LiveData<T>.observeNotNull(crossinline onChange:(T?)->Unit) = observe(this@BaseViewModelFragment, Observer {
        it?:return@Observer
        onChange(it)
    })
}