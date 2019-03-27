package com.fxy.daymatters.bean

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@Entity(tableName = "Affair")
data class Affair constructor(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var dayMatterId:Long = 0,

        @ColumnInfo(name = "title")
        var title: String? = "",

        @ColumnInfo(name = "startTime")
        var startTime: String? = null,

        @ColumnInfo(name = "classify")
        var classify: String? = null,

        @ColumnInfo(name = "isTop")
        var isTop: Boolean = false,

        @ColumnInfo(name = "isChineseDay")
        var isChineseDay: Boolean = false,

        @ColumnInfo(name = "endTime")
        var endTime: String?  = null,//结束日期可以为空

        @ColumnInfo(name = "background")
        var background: String? = null,

        @ColumnInfo(name = "textColor")
        var textColor: String = "#FFFFFF"
):Serializable