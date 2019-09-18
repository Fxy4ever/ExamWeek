package com.fxy.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.alibaba.android.arouter.launcher.ARouter
import com.fxy.lib.config.DAY_AFFAIR
import com.fxy.lib.config.DAY_MAIN
import com.fxy.lib.config.TODO_MAIN
import com.fxy.lib.ui.BaseActivity
import com.fxy.main.util.disableShiftMode
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity(override val isFragmentActivity: Boolean = true) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        common_toolbar.init("倒数日",listener = null)

        initNav()
        val t = supportFragmentManager.beginTransaction()
        t.replace(R.id.main_container,getFragment(DAY_MAIN))
        t.commit()
    }

    override fun onResume() {
        super.onResume()
    }

    private fun getFragment(path :String): Fragment{
        return ARouter.getInstance().build(path).navigation() as Fragment
    }


    private fun initNav(){
        val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_day_matters -> {
                    common_toolbar.init("倒数日",listener = null)
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.main_container,getFragment(DAY_MAIN))
                    t.commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_tomato_alert -> {
                    common_toolbar.init("番茄闹钟",listener = null)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_mine_todo -> {
                    common_toolbar.init("我的待办",listener = null)
                    val t = supportFragmentManager.beginTransaction()
                    t.replace(R.id.main_container,getFragment(TODO_MAIN))
                    t.commit()
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
