package com.fxy.lib

import android.annotation.SuppressLint
import android.content.Context
import android.support.multidex.BuildConfig
import android.support.multidex.MultiDex
import android.support.multidex.MultiDexApplication
import com.alibaba.android.arouter.launcher.ARouter
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
open class BaseApp : MultiDexApplication() {

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

    override fun onCreate() {
        super.onCreate()
        initARouter()
        initUM()
    }

    private fun initARouter(){
        if(BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }

    private fun initUM(){
        UMConfigure.init(applicationContext,UMConfigure.DEVICE_TYPE_PHONE,"5c52d1d0b465f508fe00026d")
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL)
        MobclickAgent.openActivityDurationTrack(false)
        //调试模式（推荐到umeng注册测试机，避免数据污染）
        UMConfigure.setLogEnabled(BuildConfig.DEBUG)
    }
}