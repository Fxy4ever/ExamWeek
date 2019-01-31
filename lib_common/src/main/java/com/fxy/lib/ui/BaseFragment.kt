package com.fxy.lib.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import com.fxy.lib.event.EmptyEvent
import com.umeng.analytics.MobclickAgent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
abstract class BaseFragment:Fragment() {
    //若fragment为容器，设置此为false
    protected abstract val isFragmentContainer:Boolean

    override fun onResume() {
        super.onResume()
        if (!isFragmentContainer) {
            MobclickAgent.onPageStart(javaClass.name)
        }
    }

    override fun onPause() {
        super.onPause()
        if (!isFragmentContainer) {
            MobclickAgent.onPageEnd(javaClass.name)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        EventBus.getDefault().register(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode =  ThreadMode.MAIN)
    open fun onEmptyEvent(event: EmptyEvent){
        //...以后有什么需要添加再改
    }
}