package com.fxy.main.util

import android.annotation.SuppressLint
import android.support.design.internal.BottomNavigationItemView
import android.support.design.internal.BottomNavigationMenuView
import android.support.design.widget.BottomNavigationView

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */

@SuppressLint("RestrictedApi")
fun disableShiftMode(view : BottomNavigationView){
    val menu = view.getChildAt(0) as BottomNavigationMenuView

    try {
        val shiftingMode = menu::class.java.getDeclaredField("mShiftingMode")
        shiftingMode.isAccessible = true
        shiftingMode.setBoolean(menu, false)
        shiftingMode.isAccessible = false

        for (i in 0..menu.childCount) {
            if(menu.getChildAt(i)!=null){
                val item = menu.getChildAt(i) as BottomNavigationItemView
                //noinspection RestrictedApi
                item.setShiftingMode(false)
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.itemData.isChecked)
            }
        }
    }catch (e:NoSuchFieldException){

    }catch (e:IllegalAccessException){

    }
}