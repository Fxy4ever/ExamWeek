package com.fxy.moduletodo.debug

import android.os.Bundle
import com.fxy.lib.ui.BaseActivity
import com.fxy.moduletodo.R
import com.fxy.moduletodo.ui.MainFragment

class TestActivity : BaseActivity() {

    override val isFragmentActivity: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.todo_activity_main)
        common_toolbar.init("todo",listener = null)
        initFragment()
    }


    private fun initFragment(){
        val transaction = supportFragmentManager.beginTransaction()
        val fragment = MainFragment()
        transaction.replace(R.id.todo_main_fragment,fragment).commit()
    }
}
