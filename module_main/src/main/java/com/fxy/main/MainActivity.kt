package com.fxy.main

import android.os.Bundle
import com.fxy.lib.ui.BaseActivity

class MainActivity(
        override val isFragmentActivity: Boolean = true) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        common_toolbar.init("考试周")

    }
}
