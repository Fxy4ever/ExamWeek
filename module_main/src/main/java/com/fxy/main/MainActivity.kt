package com.fxy.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.fxy.lib.ui.BaseActivity
import com.fxy.main.util.disableShiftMode
import kotlinx.android.synthetic.main.main_activity_main.*

class MainActivity(override val isFragmentActivity: Boolean = true) : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity_main)
        main_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        disableShiftMode(main_navigation)
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.nav_day_matters -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_tomato_alert -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_mine_word -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.nav_setting -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
