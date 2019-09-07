package com.fxy.daymatters.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.SeekBar
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.event.FinishDetailEvent
import com.fxy.daymatters.ui.adapter.MyFragPagerAdapter
import com.fxy.daymatters.util.CardTransformer
import com.fxy.daymatters.util.Injection
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.ui.BaseActivity
import com.fxy.lib.utils.extensions.observeNotNull
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.day_activity_affair_detail.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class AffairDetailActivity : BaseActivity() {
    private lateinit var affairs: MutableList<Affair>
    private var curPosition:Int = 0
    private lateinit var mAdapter: MyFragPagerAdapter

    override val isFragmentActivity: Boolean = false
    private lateinit var model:CommitAffairViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_activity_affair_detail)
        common_toolbar.init("倒数日")
        initLiveData()
        initVp()
    }

    override fun onResume() {
        super.onResume()
        model.getAffairs()
    }

    private fun initLiveData(){
        val factory = Injection.provideViewModelFactory(this)
        model = ViewModelProviders.of(this,factory).get(CommitAffairViewModel::class.java)
        model.getAffairs()
        model.mAffairs.observeNotNull(this) {
            it?.let {data->
                affairs.clear()
                affairs.addAll(data)
                mAdapter.notifyDataSetChanged()
                day_detail_vp.currentItem = curPosition
            }
        }
    }

    private fun initVp(){
        affairs = mutableListOf()
        curPosition = intent.getIntExtra("curPosition",0)
        mAdapter = MyFragPagerAdapter(affairs,supportFragmentManager)
        day_detail_vp.adapter = mAdapter
        day_detail_vp.offscreenPageLimit = 3
        day_detail_vp.setPageTransformer(true,CardTransformer())
        //解决clipChildren的滑动冲突
        day_detail_container.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                day_detail_container.requestDisallowInterceptTouchEvent(true)
                return day_detail_vp.dispatchTouchEvent(event)
            }
        })
        day_detail_vp.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                curPosition = position
            }
        })
        day_detail_edit.setOnClickListener {
            val intent = Intent(this@AffairDetailActivity,CommitAffairActivity::class.java)
            intent.putExtra("affair",Gson().toJson(affairs[curPosition]))
            startActivity(intent)
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun finishCurActivity(event: FinishDetailEvent){
        finish()
    }
}
