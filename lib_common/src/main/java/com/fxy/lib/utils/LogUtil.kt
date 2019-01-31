package com.fxy.lib.utils

import android.util.Log
import com.exam.lib_common.BuildConfig

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
/**控制想要打印的日志级别
 * 等于VERBOSE，则就会打印所有级别的日志
 * 等于WARN，则只会打印警告级别以上的日志
 * 等于NOTHING，则会屏蔽掉所有日志 */

object LogUtil {
    private val isDebug = BuildConfig.DEBUG

    fun v(msg: String, tag: String = "tag") {
        if (isDebug)
            Log.v(tag, msg)
    }

    fun d(msg: String, tag: String = "tag") {
        if (isDebug)
            Log.d(tag, msg)
    }

    fun i(msg: String, tag: String = "tag") {
        if (isDebug)
            Log.i(tag, msg)
    }

    fun w(msg: String, tag: String = "tag") {
        if (isDebug)
            Log.w(tag, msg)
    }

    fun e(msg: String, tag: String = "tag") {
        if (isDebug)
            Log.e(tag, msg)
    }

}