package com.fxy.lib.utils.extensions

import android.content.Context
import android.content.SharedPreferences
import com.fxy.lib.config.SP_DEFAULT_NAME

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
fun Context.getSp(name: String = SP_DEFAULT_NAME): SharedPreferences = getSharedPreferences(name, Context.MODE_PRIVATE)

fun SharedPreferences.editor(editBuilder: SharedPreferences.Editor.() -> Unit) {
    edit().apply(editBuilder).apply()
}
