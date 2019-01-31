package com.fxy.lib.utils.extensions

import android.net.Uri
import android.os.Build
import android.support.v4.content.FileProvider
import com.fxy.lib.BaseApp
import java.io.File

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
val File.getUri :Uri
    get() = if(Build.VERSION.SDK_INT >= 24) FileProvider.getUriForFile(BaseApp.context,"com.exam.FileProvider",this)
            else Uri.fromFile(this)

