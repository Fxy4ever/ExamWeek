package com.fxy.daymatters.util

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.fxy.daymatters.dao.DayMatterDao
import com.fxy.daymatters.db.DayMatterDatabase
import com.fxy.daymatters.viewmodel.AffairViewModelFactory

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */

object Injection{
    fun provideAffariDataSrouce(context: Context):DayMatterDao{
        return DayMatterDatabase.getInstance(context).dayMattersDao()
    }

    fun provideViewModelFactory(context: Context):ViewModelProvider.Factory{
        return AffairViewModelFactory(provideAffariDataSrouce(context))
    }
}