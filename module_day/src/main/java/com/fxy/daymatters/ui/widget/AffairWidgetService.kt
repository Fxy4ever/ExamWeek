package com.fxy.daymatters.ui.widget

import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import android.util.Log
import android.util.TypedValue
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.util.getDayFromNow
import com.fxy.daymatters.util.getToday
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.defaultSharedPreferences

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */
class AffairWidgetService : RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory? {
        if (intent != null) {
            return AffairWidgetFactory(this, intent, intent.getStringExtra("classify"))
        }
        return null
    }


    inner class AffairWidgetFactory(val context: Context,
                                    private val intent: Intent,
                                    val classify: String) : RemoteViewsService.RemoteViewsFactory {
        private lateinit var data: MutableList<Affair>
        private var temp: MutableList<Affair> = mutableListOf()//临时保存
        private var appWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID)

        override fun onCreate() {
            initData()
        }

        private fun initData() {
            val type = object : TypeToken<MutableList<Affair>>() {}.type
            data = Gson().fromJson(
                    context.defaultSharedPreferences.getString(AffairSmallWidget.sharedName, "")
                    , type
            )
            temp.addAll(data)
        }



        override fun getViewAt(position: Int): RemoteViews {
            var rv: RemoteViews = RemoteViews(context.packageName, R.layout.day_widget_item_blue)
            if (data != null && data.size > 0) {
                val endTime = data[position].endTime ?: ""

                if (!endTime.isNotEmpty()) {//endDay为空，说明不是计算间隔
                    val betweenDay = getDayFromNow(getToday(), data[position].startTime!!)
                    if (betweenDay > 0) {//如果时间还没到
                        rv = RemoteViews(context.packageName, R.layout.day_widget_item_blue)
                        rv.setTextViewText(R.id.day_item_hor_title, "${data[position].title}还有")
                        rv.setTextViewText(R.id.day_item_hor_num, "${Math.abs(betweenDay)}")
                        rv.setTextViewTextSize(R.id.day_item_hor_title, TypedValue.COMPLEX_UNIT_SP,14.0f)
                        setFillIntent(position, R.id.day_item_hor_layout, rv)
                    } else {  //如果时间已经过了
                        rv = RemoteViews(context.packageName, R.layout.day_widget_item_red)
                        rv.setTextViewText(R.id.day_item_red_hor_title, "${data[position].title}已经")
                        rv.setTextViewText(R.id.day_item_red_hor_num, "${Math.abs(betweenDay)}")
                        rv.setTextViewTextSize(R.id.day_item_red_hor_title, TypedValue.COMPLEX_UNIT_SP,14.0f)
                        setFillIntent(position, R.id.day_item_red_hor_layout, rv)
                    }

                } else {
                    val betweenDay = getDayFromNow(endTime, data[position].startTime!!)
                    rv = RemoteViews(context.packageName, R.layout.day_widget_item_red)
                    rv.setTextViewText(R.id.day_item_red_hor_title, "${data[position].title}共")
                    rv.setTextViewText(R.id.day_item_red_hor_num, "${Math.abs(betweenDay)}")
                    rv.setTextViewTextSize(R.id.day_item_red_hor_title, TypedValue.COMPLEX_UNIT_SP,14.0f)
                    setFillIntent(position, R.id.day_item_red_hor_layout, rv)
                }
            }

            return rv
        }

        private fun setFillIntent(position: Int, id: Int, rv: RemoteViews) {
            val fillIntent = Intent()
            fillIntent.putExtra(AffairSmallWidget.COLLECTION_VIEW_EXTRA, position)
            rv.setOnClickFillInIntent(id, fillIntent)
        }

        override fun getLoadingView(): RemoteViews? = null

        override fun getItemId(position: Int): Long = position.toLong()

        override fun onDataSetChanged() {
            data.clear()
            data.addAll(temp)
            if(AffairSmallWidget.curClassify != "全部"){
                data = data.filter { it.classify == AffairSmallWidget.curClassify }.toMutableList()
            }
        }

        override fun hasStableIds(): Boolean = true

        override fun getCount(): Int = data.size

        override fun getViewTypeCount(): Int = 2

        override fun onDestroy() {
            data.clear()
        }
    }
}