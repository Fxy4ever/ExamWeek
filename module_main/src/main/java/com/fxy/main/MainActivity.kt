package com.fxy.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.fxy.lib.ui.BaseActivity
import com.fxy.main.util.disableShiftMode
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity(override val isFragmentActivity: Boolean = true) : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        common_toolbar.init("倒数日",listener = null)
        initNav()
    }


    private fun initNav(){
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_day_matters -> {
                    common_toolbar.init("倒数日",listener = null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_tomato_alert -> {
                    common_toolbar.init("番茄闹钟",listener = null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_mine_todo -> {
                    common_toolbar.init("我的待办",listener = null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_setting -> {
                    common_toolbar.init("设置",listener = null)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        main_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        disableShiftMode(main_navigation)
    }



}
