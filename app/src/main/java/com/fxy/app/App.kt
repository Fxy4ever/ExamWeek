package com.fxy.app

import android.content.Context
import android.os.Process
import android.support.multidex.MultiDex
import com.alibaba.android.arouter.launcher.ARouter
import com.exam.app.BuildConfig
import com.fxy.lib.BaseApp
import com.fxy.lib.utils.getAppVersionName
import com.fxy.lib.utils.getProcessName
import com.tencent.bugly.crashreport.CrashReport

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
class App : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        initBugly()
        if(BuildConfig.DEBUG){
            ARouter.openDebug()
            ARouter.openLog()
        }
        ARouter.init(this)
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(context)
    }

    private fun initBugly(){
        //bugly文档配置
        val packageName = applicationContext.packageName
        val processName = getProcessName(Process.myPid())
        val strategy = CrashReport.UserStrategy(applicationContext)
        strategy.appVersion = getAppVersionName(applicationContext)
        strategy.isUploadProcess = processName == null || processName == packageName
        CrashReport.initCrashReport(applicationContext, BuildConfig.BUGLY_APP_ID, BuildConfig.DEBUG,strategy)
        if(BuildConfig.DEBUG)
            CrashReport.setUserSceneTag(applicationContext,10000)//自定义标签
    }
}