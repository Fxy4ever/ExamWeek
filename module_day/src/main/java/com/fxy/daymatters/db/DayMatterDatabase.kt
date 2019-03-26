package com.fxy.daymatters.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.dao.DayMatterDao

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@Database(entities = [Affair::class],version = 1)
abstract class DayMatterDatabase : RoomDatabase() {
    abstract fun dayMattersDao():DayMatterDao
}