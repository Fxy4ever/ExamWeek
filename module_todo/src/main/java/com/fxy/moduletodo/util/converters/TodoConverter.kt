package com.fxy.moduletodo.util.converters

import android.arch.persistence.room.TypeConverter
import com.fxy.moduletodo.bean.Step
import com.fxy.moduletodo.bean.TodoList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TodoConverter {
    @TypeConverter
    fun stringToObject(value: String): List<Step> {
        val listType = object : TypeToken<List<Step>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun objectToString(list: List<Step>): String {
        val gson = Gson()
        return gson.toJson(list)
    }
}