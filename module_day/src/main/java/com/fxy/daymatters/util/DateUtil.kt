package com.fxy.daymatters.util

import android.annotation.SuppressLint
import com.fxy.daymatters.ui.DayMatterFragment.Companion.cal
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*



/**
 * create by:Fxymine4ever
 * time: 2019/3/27
 */

@SuppressLint("SimpleDateFormat")
fun getChineseDayOfWeek(time:String):String{
    val arr = arrayOf("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
    var date = Date()
    val sdf = SimpleDateFormat("yyyy-MM-dd")
    try{
        date = sdf.parse(time)
    }catch (e: ParseException){
        e.printStackTrace()
    }
    cal.time = date
    var cur = cal.get(Calendar.DAY_OF_WEEK) - 1
    if(cur < 0)
        cur = 0
    return arr[cur]
}

fun getToday():String{
    val df = SimpleDateFormat("yyyy-MM-dd")//设置日期格式
    return df.format(Date())
}
/**
 * 2019-03-27 星期三，先通过空格分日期和星期，然后通过-拿到年月日
 */
fun getDateFromString(date:String): IntArray {
    val temp = date.split(" ")
    val dates = temp[0].split("-")
    return intArrayOf(dates[0].toInt(),dates[1].toInt(),dates[2].toInt())
}

fun getDayFromNow(startDay:String,nowDay:String):Int{
    val firstString = startDay.split(" ")[0]
    val secondString = nowDay.split(" ")[0]
    return getDaysBetweenTwoDate(firstString,secondString)
}

fun getDaysBetweenTwoDate(firstString: String, secondString: String): Int {
    val df = SimpleDateFormat("yyyy-MM-dd")
    var firstDate: Date? = null
    var secondDate: Date? = null
    try {
        firstDate = df.parse(firstString)
        secondDate = df.parse(secondString)
    } catch (e: Exception) {
        // 日期型字符串格式错误
        println("日期型字符串格式错误")
    }
    return ((secondDate!!.time - firstDate!!.time) / (24 * 3600 * 1000)).toInt()
}

