package com.fxy.lib.utils.extensions

import android.content.Context
import android.graphics.Point
import android.support.annotation.DrawableRes
import android.view.WindowManager
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.exam.lib_common.R

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
var screenHeight: Int = 0
var screenWidth: Int = 0
fun Context.getScreenHeight(): Int {
    if (screenHeight == 0) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenHeight = size.y
    }
    return screenHeight
}

fun Context.getScreenWidth(): Int {
    if (screenHeight == 0) {
        val windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        screenWidth = size.x
    }
    return screenWidth
}

fun Context.loadImage(url: String?,
                      imageView: ImageView,
                      @DrawableRes placeholder: Int = R.drawable.holder,
                      @DrawableRes error: Int = R.drawable.error) {
    url?.let {
        Glide.with(this)
                .load(it)
                .transition(DrawableTransitionOptions().crossFade())
                .apply(RequestOptions().placeholder(placeholder).error(error))
                .into(imageView)
    }
}