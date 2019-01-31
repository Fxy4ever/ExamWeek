package com.fxy.lib.utils.extensions

import android.provider.SyncStateContract.Helpers.update
import okio.ByteString
import java.io.UnsupportedEncodingException
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */

fun String.toMD5():String{
    try {
        val messageDigest = MessageDigest.getInstance("MD5")
        val md5bytes = messageDigest.digest(this.toByteArray(charset("UTF-8")))
        return ByteString.of(*md5bytes).hex()
    } catch (e: NoSuchAlgorithmException) {
        throw AssertionError(e)
    } catch (e: UnsupportedEncodingException) {
        throw AssertionError(e)
    }
}