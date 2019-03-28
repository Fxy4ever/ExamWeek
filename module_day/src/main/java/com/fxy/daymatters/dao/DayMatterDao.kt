package com.fxy.daymatters.dao

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.arch.persistence.room.*
import com.fxy.daymatters.bean.Affair
import io.reactivex.Flowable
import io.reactivex.Observable

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@Dao
interface DayMatterDao {

    @Query("select * from Affair")
    fun getDayMatters():Flowable<MutableList<Affair>>

    @Query("select * from Affair where classify = :classify")
    fun getDayMattersByKind(classify:String):Flowable<MutableList<Affair>>

    @Insert
    fun insertDayMatters(bean:Affair):Long

    @Update
    fun updateDayMatters(bean:Affair):Int//根据primaryKey更新

    @Delete
    fun deleteDayMatters(bean:Affair):Int
}