package com.fxy.daymatters.debug

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
class TestApplication : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
            private set
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        context = base
        MultiDex.install(this)
    }

}