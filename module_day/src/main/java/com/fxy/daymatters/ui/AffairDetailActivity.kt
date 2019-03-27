package com.fxy.daymatters.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.adapter.MyFragPagerAdapter
import com.fxy.daymatters.util.CardTransformer
import com.fxy.lib.ui.BaseActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.day_activity_affair_detail.*

class AffairDetailActivity : BaseActivity() {
    private lateinit var affairs: MutableList<Affair>
    private var curPosition:Int = 0
    private lateinit var mAdapter: MyFragPagerAdapter

    override val isFragmentActivity: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_activity_affair_detail)
        common_toolbar.init("倒数日")
        getData()
    }

    private fun getData(){
        val type = object : TypeToken<MutableList<Affair>>(){}.type
        affairs = Gson().fromJson(intent.getStringExtra("data"),type)
        curPosition = intent.getIntExtra("curPosition",0)
        mAdapter = MyFragPagerAdapter(affairs,supportFragmentManager)
        day_detail_vp.adapter = mAdapter
        day_detail_vp.currentItem = curPosition
        day_detail_vp.offscreenPageLimit = 3
        day_detail_vp.setPageTransformer(true,CardTransformer())
        //解决clipChildren的滑动冲突
        day_detail_container.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                day_detail_container.requestDisallowInterceptTouchEvent(true)
                return day_detail_vp.dispatchTouchEvent(event)
            }
        })
    }
}
