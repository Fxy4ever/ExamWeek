package com.fxy.lib.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import com.fxy.lib.ui.BaseActivity
import com.fxy.lib.ui.BaseFragment
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * create by:Fxymine4ever
 * time: 2019/3/20
 */
class ViewModelDelegate<out T: ViewModel>(
        private val clazz: KClass<T>,
        private val fromActivity:Boolean
){
    private var viewModel: T? = null

    operator fun getValue(reference:BaseActivity,property:KProperty<*>)
            = buildViewModel(activity = reference)

    operator fun getValue(reference: BaseFragment, property: KProperty<*>) = if (fromActivity)
        buildViewModel(activity = reference.activity as? BaseActivity
                ?: throw IllegalStateException("Activity must be as BaseActivity"))
    else buildViewModel(fragment = reference)


    private fun buildViewModel(activity: BaseActivity? = null, fragment: BaseFragment? = null): T{
        if(viewModel != null) return viewModel!!

        activity?.let {
            viewModel = ViewModelProviders.of(it).get(clazz.java)
        } ?: fragment?.let {
            viewModel = ViewModelProviders.of(it).get(clazz.java)
        } ?: throw IllegalStateException("Activity or Fragment is null! ")

        return viewModel!!
    }

    fun <T : ViewModel> BaseActivity.viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz, true)

    // fromActivity默认为true，viewModel生命周期默认跟activity相同
    fun <T : ViewModel> BaseFragment.viewModelDelegate(clazz: KClass<T>, fromActivity: Boolean = true) = ViewModelDelegate(clazz, fromActivity)


}