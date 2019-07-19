package com.fxy.moduletodo.util

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import com.fxy.moduletodo.dao.TodoListDao
import com.fxy.moduletodo.db.TodoListDatabase
import com.fxy.moduletodo.viewmodel.TodoListViewModel

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */

object Injection{
    fun provideAffariDataSrouce(context: Context):TodoListDao{
        return TodoListDatabase.getInstance(context).todoListDao()
    }

    fun provideViewModelFactory(context: Context):ViewModelProvider.Factory{
        return TodoListViewModel.Factory(provideAffariDataSrouce(context))
    }
}