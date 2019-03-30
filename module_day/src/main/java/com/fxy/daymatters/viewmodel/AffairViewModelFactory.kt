package com.fxy.daymatters.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.fxy.daymatters.dao.DayMatterDao
import java.lang.IllegalArgumentException

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */
class AffairViewModelFactory(private val dataSource: DayMatterDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CommitAffairViewModel::class.java))
            return CommitAffairViewModel(dataSource) as T
        throw IllegalArgumentException("未知的ViewModel class")
    }
}