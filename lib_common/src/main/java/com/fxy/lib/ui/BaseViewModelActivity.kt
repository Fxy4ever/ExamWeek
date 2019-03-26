package com.fxy.lib.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.PersistableBundle

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
abstract class BaseViewModelActivity<T : ViewModel> : BaseActivity() {
    protected lateinit var model:T
    protected abstract var modelClass:Class<T>
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        var modelFactory = getViewModelFactory()
        if(modelFactory == null){
            model = ViewModelProviders.of(this).get(modelClass)
        }else{
            model = ViewModelProviders.of(this,modelFactory).get(modelClass)
        }
    }

    protected fun getViewModelFactory():ViewModelProvider.Factory? = null

    inline fun <T> LiveData<T>.observe(crossinline onChange:(T?)->Unit) = observe(this@BaseViewModelActivity, Observer { onChange(it) })
    inline fun <T> LiveData<T>.observeNotNull(crossinline onChange:(T?)->Unit) = observe(this@BaseViewModelActivity, Observer {
        it?:return@Observer
        onChange(it)
    })
}