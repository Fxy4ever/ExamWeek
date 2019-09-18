package com.fxy.moduletodo.bean

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.fxy.moduletodo.util.converters.TodoConverter
import java.io.Serializable

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@Entity(tableName = "TodoList")
@TypeConverters(TodoConverter::class)
data class TodoList constructor(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")//id
        var id:Long,

        @ColumnInfo(name = "content")//内容
        var content:String? = null,

        @ColumnInfo(name = "deadLine")//截止时间
        var deadLine:String? = null,

        @ColumnInfo(name = "isAddMyDay")//是否添加进我的一天
        var isAddMyDay:Boolean = false,

        @ColumnInfo(name = "isFinish")//是否完成
        var isFinish:Boolean = false,

        @ColumnInfo(name = "isImportant")//是否重要
        var isImportant:Boolean = false,

        @ColumnInfo(name = "steps")//步骤
        var steps:MutableList<Step>? = null,

        @ColumnInfo(name = "notes")
        var notes:String? = null
):Serializable

data class Step(
        val content: String
)