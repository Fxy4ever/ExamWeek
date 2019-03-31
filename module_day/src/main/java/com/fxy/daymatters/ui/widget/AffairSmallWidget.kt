package com.fxy.daymatters.ui.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.annotation.IdRes
import android.util.Log
import android.view.SoundEffectConstants.CLICK
import android.view.View
import android.widget.RemoteViews

import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Classify
import com.fxy.daymatters.debug.TestActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


class AffairSmallWidget : AppWidgetProvider() {

    companion object {
        const val sharedName = "com.fxy.exam.widget"
        const val sharedClassify = "com.fxy.exam.classify"
        const val BTN_CLICK = "com.fxy.exam.widget.click"
        const val COLLECTION_VIEW_EXTRA = "com.fxy.exam.widget.view.extra"
        const val COLLECTION_VIEW_ACTION = "com.fxy.exam.widget.view.action"
        var curPosition = 0
        lateinit var classify:MutableList<Classify>
        var widgetId:Int = -1
        lateinit var curClassify:String
    }

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        widgetId = appWidgetIds[0]
        refresh(context)
    }

    private fun setListView(context: Context,rv:RemoteViews,classify:String){
        //serviceIntent绑定适配器
        val serviceIntent = Intent(context,AffairWidgetService::class.java)
        serviceIntent.putExtra("classify",classify)
        rv.setRemoteAdapter(R.id.day_widget_list,serviceIntent)
    }

    private fun refresh(context: Context
                        ){
        val rv = getRemotesView(context)
        //前后点击事件
        rv.setOnClickPendingIntent(getLeftButtonId(),
                getClickPendingIntent(context,getLeftButtonId(), BTN_CLICK,javaClass))
        rv.setOnClickPendingIntent(getRightButtonId(),
                getClickPendingIntent(context,getRightButtonId(), BTN_CLICK,javaClass))
        rv.setOnClickPendingIntent(getTitleTextViewId(),
                getClickPendingIntent(context,getTitleTextViewId(), BTN_CLICK,javaClass))


        val typeToken = object : TypeToken<MutableList<Classify>>(){}.type
        classify = Gson().fromJson(context.defaultSharedPreferences.getString(sharedClassify,mutableListOf<Classify>().toString()),typeToken)

        curClassify = classify[curPosition].name
        rv.setViewVisibility(getRightButtonId(), View.VISIBLE)
        rv.setViewVisibility(getLeftButtonId(), View.VISIBLE)
        if(curPosition == 0){
            rv.setViewVisibility(getLeftButtonId(), View.GONE)
        }
        if(curPosition == classify.size-1){
            rv.setViewVisibility(getRightButtonId(), View.GONE)
        }

        setListView(context,rv,classify[curPosition].name)

        rv.setTextViewText(getTitleTextViewId(),"考试周 - ${classify[curPosition].name}")

        val componentName = ComponentName(context, javaClass)
            /*
            集合不能直接设置点击事件
            需要1、设置intent模版
               2、通过RemoteViewFactory的getViewAt接口中，设置setOnClickFillIntent设置集合某一数据
             */
        val listIntent = Intent()
        listIntent.action = COLLECTION_VIEW_ACTION
        listIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,componentName)
        val pi = PendingIntent.getBroadcast(context,0,listIntent,PendingIntent.FLAG_UPDATE_CURRENT)

        rv.setPendingIntentTemplate(R.id.day_widget_list,pi)

        show(rv,context)
    }

    private fun show(remoteViews: RemoteViews, context: Context) {
        val manager = AppWidgetManager.getInstance(context)
        val componentName = ComponentName(context, javaClass)
        manager.updateAppWidget(componentName, remoteViews)
        manager.notifyAppWidgetViewDataChanged(widgetId,R.id.day_widget_list)
    }

    private fun getClickPendingIntent(context: Context, @IdRes resId: Int, action: String, clazz: Class<AppWidgetProvider>): PendingIntent {
        val intent = Intent()
        intent.setClass(context, clazz)
        intent.action = action
        intent.data = Uri.parse("id:$resId")
        return PendingIntent.getBroadcast(context, 0, intent, 0)
    }



    override fun onReceive(context: Context?, intent: Intent?) {
        intent?.let { i->
            val action = i.action
            if(action == COLLECTION_VIEW_ACTION){
                val appWidgetId = i.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                        AppWidgetManager.INVALID_APPWIDGET_ID)
                val viewIndex = i.getIntExtra(COLLECTION_VIEW_EXTRA,0)

            }else if(action == BTN_CLICK){
                val data = i.data
                var rId = -1
                if(data!=null)
                    rId = data.schemeSpecificPart.toInt()

                when(rId){
                    getLeftButtonId()->{
                        if(curPosition>0){
                            curPosition--
                            refresh(context!!)
                        }
                    }
                    getRightButtonId()->{
                        if(curPosition < classify.size-1){
                            curPosition++
                            refresh(context!!)
                        }
                    }
                    getTitleTextViewId()->{
                        val mIntent = Intent(context,TestActivity::class.java)
                        context.startActivity(mIntent)
                    }

                }
            }
        }
        super.onReceive(context, intent)
    }


    private fun getLeftButtonId():Int = R.id.day_widget_left

    private fun getRightButtonId():Int = R.id.day_widget_right

    private fun getTitleTextViewId():Int = R.id.day_widget_text

    private fun getRemotesView(context: Context):RemoteViews = RemoteViews(context.packageName,R.layout.day_widget_small_affair)
}

