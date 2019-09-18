package com.fxy.lib.utils

import android.annotation.TargetApi
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.ContextWrapper
import android.os.Build
import android.support.v4.app.NotificationCompat.VISIBILITY_SECRET
import android.R
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationCompat.PRIORITY_DEFAULT
import android.graphics.BitmapFactory
import android.app.PendingIntent





/**
 * create by:Fxymine4ever
 * time: 2019/3/31
 */
class NotificationUtils(base: Context?) : ContextWrapper(base) {
    companion object {
        const val CHANNEL_ID = "com.fxy.exam"
        const val CHANNEL_NAME = "com.fxy.exam.notify"
    }
    private val manager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    init {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createNotificationChannel()
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(){
        val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT)
        channel.canBypassDnd()
        channel.lockscreenVisibility = VISIBILITY_SECRET
        channel.canShowBadge()
        channel.enableVibration(true)
        channel.setBypassDnd(true)
        channel.vibrationPattern = longArrayOf(100, 100, 200)
        getManager().createNotificationChannel(channel)
    }

    private fun getManager():NotificationManager{
        return manager
    }

    fun sendNotification(title: String, content: String,pendingIntent: PendingIntent) {
        val builder = getNotification(title, content,pendingIntent)
        getManager().notify((Math.random()*1000).toInt(), builder!!.build())//notify的id设置为不同，显示多个notification
    }

    private fun getNotification(title: String, content: String,pendingIntent: PendingIntent): NotificationCompat.Builder? {
        val builder: NotificationCompat.Builder?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        } else {
            builder = NotificationCompat.Builder(applicationContext)
            builder.priority = PRIORITY_DEFAULT
        }
        //标题
        builder.setContentTitle(title)
        //文本内容
        builder.setContentText(content)
        //小图标
        builder.setSmallIcon(R.drawable.ic_dialog_email)////TODO:通知的icon
        //设置点击信息后自动清除通知
        builder.setAutoCancel(true)

        builder.setContentIntent(pendingIntent)
        return builder
    }

    fun sendNotificationProgress(title: String, content: String, progress: Int, intent: PendingIntent) {
        val builder = getNotificationProgress(title, content, progress, intent)
        getManager().notify(0, builder.build())
    }

    private fun getNotificationProgress(title: String, content: String,
                                        progress: Int, intent: PendingIntent): NotificationCompat.Builder {
        var builder: NotificationCompat.Builder? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
        } else {
            builder = NotificationCompat.Builder(applicationContext)
            builder.priority = PRIORITY_DEFAULT
        }
        builder.setContentTitle(title)
        builder.setContentText(content)
        builder.setSmallIcon(R.drawable.ic_dialog_email)
        builder.setLargeIcon(BitmapFactory.decodeResource(resources, R.drawable.ic_dialog_email))
        if (progress > 0 && progress < 100) {
            builder.setProgress(100, progress, false)
        } else {
            builder.setProgress(0, 0, false)
            builder.setContentText("下载完成")
        }
        builder.setAutoCancel(true)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentIntent(intent)
        return builder
    }
}