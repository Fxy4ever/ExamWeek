package com.fxy.daymatters.debug

import android.os.Bundle
import com.fxy.daymatters.ui.DayMatterFragment
import com.fxy.daymatters.R
import com.fxy.lib.ui.BaseActivity

class TestActivity(override val isFragmentActivity: Boolean = true) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.day_activity_test)
        common_toolbar.init("倒数日")
        initFragment()
    }

    private fun initFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = DayMatterFragment()
        transaction.replace(R.id.daymatters_fragment_container,fragment)
        transaction.commit()
    }
}
