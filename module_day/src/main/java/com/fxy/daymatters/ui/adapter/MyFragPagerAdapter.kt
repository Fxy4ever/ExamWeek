package com.fxy.daymatters.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.AffairDetailFragment

/**
 * create by:Fxymine4ever
 * time: 2019/3/27
 */
class MyFragPagerAdapter(private val list: MutableList<Affair>,fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment{
        val fragment = AffairDetailFragment()
        fragment.affair = list[position]
        return fragment
    }

    override fun getCount(): Int = list.size
}