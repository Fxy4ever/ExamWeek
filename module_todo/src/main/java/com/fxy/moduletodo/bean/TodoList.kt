package com.fxy.moduletodo.bean

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@Entity(tableName = "TodoList")
data class TodoList constructor(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id:Long,

        @ColumnInfo(name = "content")
        var content:String? = null,

        @ColumnInfo(name = "deadLine")
        var deadLine:String? = null,

        @ColumnInfo(name = "isAddMyDay")
        var isAddMyDay:Boolean = false,

        @ColumnInfo(name = "isFinish")
        var isFinish:Boolean = false,

        @ColumnInfo(name = "isImportant")
        var isImportant:Boolean = false
):Serializable
