package com.fxy.daymatters.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.dao.DayMatterDao

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@Database(entities = [Affair::class],version = 1,exportSchema = false)
abstract class DayMatterDatabase : RoomDatabase() {
    abstract fun dayMattersDao():DayMatterDao

    companion object {
        @Volatile private var Instance:DayMatterDatabase ?= null

        fun getInstance(context: Context):DayMatterDatabase =
                Instance ?: synchronized(this){
                    Instance ?: buildDatabase(context)
                }

        fun buildDatabase(context: Context)=
                Room.databaseBuilder(context.applicationContext,
                        DayMatterDatabase::class.java,"DayMatter.db").build()
    }
}