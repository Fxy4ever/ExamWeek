package com.fxy.moduletodo.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.fxy.moduletodo.bean.TodoList
import com.fxy.moduletodo.dao.TodoListDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.IllegalArgumentException

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
class TodoListViewModel(private val dataSource: TodoListDao?) : ViewModel() {

    val todoList:MutableLiveData<MutableList<TodoList>> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MutableList<TodoList>>()
    }

    fun getTodoList(){
        dataSource?.let {dao->
            dao.getTodoList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        todoList.value = it
                    }
        }
    }

    class Factory (private val dataSource: TodoListDao) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(TodoListViewModel::class.java))
                return TodoListViewModel(dataSource) as T
            throw IllegalArgumentException("未知的ViewModel class")
        }
    }
}