package com.fxy.moduletodo.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.fxy.moduletodo.bean.TodoList
import com.fxy.moduletodo.dao.TodoListDao

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@Database(entities = [TodoList::class],version = 1,exportSchema = false)
abstract class TodoListDatabase: RoomDatabase() {
    abstract fun todoListDao():TodoListDao

    companion object {
        @Volatile private var INSTANCE:TodoListDatabase? = null
        fun getInstance(context: Context):TodoListDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDB(context)
            }

        private fun buildDB(context: Context) =
                Room.databaseBuilder(context,TodoListDatabase::class.java,
                        "TodoList.db").build()
    }

}