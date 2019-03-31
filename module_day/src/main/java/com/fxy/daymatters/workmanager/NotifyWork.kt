package com.fxy.daymatters.workmanager

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.TypedValue
import android.widget.RemoteViews
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.debug.TestActivity
import com.fxy.daymatters.ui.widget.AffairSmallWidget
import com.fxy.daymatters.util.getDayFromNow
import com.fxy.daymatters.util.getToday
import com.fxy.lib.utils.NotificationUtils
import com.fxy.lib.utils.extensions.editor
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.defaultSharedPreferences
import java.util.*

/**
 * create by:Fxymine4ever
 * time: 2019/3/31
 */
class NotifyWork(val context: Context,workerParams:WorkerParameters) :
        Worker(context,workerParams) {


    private val PUSHTAG = "NotifyWork"
    private lateinit var data: MutableList<Affair>

    override fun doWork(): Result {
        val isPush = applicationContext.defaultSharedPreferences.getBoolean(PUSHTAG,false)
        applicationContext.defaultSharedPreferences.editor {
            putBoolean(PUSHTAG,false)
        }
        if(compareTime(7)){//如果在当前时间
            if(isPush){//已经推送则不推送了
                return Result.RETRY
            }else{
                applicationContext.defaultSharedPreferences.editor {
                    putBoolean(PUSHTAG,true)
                }
            }
        }else{//不在当前时间Flag重置
            applicationContext.defaultSharedPreferences.editor {
                putBoolean(PUSHTAG,false)
            }
            return Result.RETRY
        }

        //TODO:合代码的时候换成主界面
        val type = object : TypeToken<MutableList<Affair>>() {}.type
        data = Gson().fromJson(
                context.defaultSharedPreferences.getString(AffairSmallWidget.sharedName, "")
                , type)
        data = data.filter { it.isNotify }.toMutableList()
        data.forEach {
            val endTime = it.endTime ?: ""
            val title = "倒数提醒"
            val content:String
            if (!endTime.isNotEmpty()) {//endDay为空，说明不是计算间隔
                val betweenDay = getDayFromNow(getToday(), it.startTime!!)
                if (betweenDay > 0) {//如果时间还没到
                    content = "距离${it.title}还有${Math.abs(betweenDay)}天了"
                } else {  //如果时间已经过了
                    content = "距离${it.title}已经${Math.abs(betweenDay)}天了"
                }

            } else {
                val betweenDay = getDayFromNow(endTime, it.startTime!!)
                content = "距离${it.title}共${Math.abs(betweenDay)}天了"
            }

            val intent = Intent(applicationContext,TestActivity::class.java)
            val pi = PendingIntent.getActivity(applicationContext,0,intent,PendingIntent.FLAG_UPDATE_CURRENT)
            NotificationUtils(applicationContext).sendNotification(
                    title,
                    content,
                    pi
            )
        }

        return Result.SUCCESS
    }

    private fun compareTime(targetHour:Int):Boolean{
        val curHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
        return targetHour == curHour
    }
}