package com.fxy.lib.ui

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.DrawableRes
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.WindowManager
import com.fxy.lib.event.EmptyEvent
import com.exam.lib_common.R
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.common_toolbar.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import org.jetbrains.anko.startActivity

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
abstract class BaseActivity : AppCompatActivity() {
    protected abstract val isFragmentActivity:Boolean//辅助umeng统计fragment

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
        if(!isFragmentActivity)
            MobclickAgent.onPageStart(javaClass.name)
    }

    @Subscribe(threadMode =  ThreadMode.MAIN)
    open fun onEmptyEvent(event: EmptyEvent){
        //...以后有什么需要添加再改
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        //沉浸式
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            val option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            decorView.systemUiVisibility = option
            window.statusBarColor = Color.TRANSPARENT
        } else if (Build.VERSION.SDK_INT >= 19) {
            window.setFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
            )
        }
    }

    protected val BaseActivity.common_toolbar get() = toolbar
    fun Toolbar.init(title: String,
                               @DrawableRes icon: Int = R.drawable.common_ic_back,
                               listener: View.OnClickListener? = View.OnClickListener { finish() }) {
        this.title = title
        setSupportActionBar(this)
        if (listener == null) {
            navigationIcon = null
        } else {
            setNavigationIcon(icon)
            setNavigationOnClickListener(listener)
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
    }

    //利用内联跳转Activity
    inline fun <reified T : Activity> startActivity(finish: Boolean = false, vararg params: Pair<String, Any?>) {
        if (finish) finish()
        startActivity<T>(*params)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
        if(!isFragmentActivity)
            MobclickAgent.onPageEnd(javaClass.name)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}