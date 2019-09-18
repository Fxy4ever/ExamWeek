package com.fxy.moduletodo.dao

import android.arch.persistence.room.*
import com.fxy.moduletodo.bean.TodoList
import io.reactivex.Flowable

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@Dao
interface TodoListDao {
    @Insert
    fun insertTodo(todo: TodoList):Long

    @Update
    fun updateTodo(todo: TodoList):Int

    @Delete
    fun deleteTodo(todo: TodoList):Int

    @Query("SELECT * FROM TodoList")
    fun getTodoList():Flowable<MutableList<TodoList>>
}