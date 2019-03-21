package com.fxy.lib.network

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Function
import org.reactivestreams.Publisher
import java.lang.Exception
import java.util.concurrent.TimeUnit

/**
 * create by:Fxymine4ever
 * 用于网络失败后重试
 * time: 2019/3/20
 */
class NetworkRetry(private val maxRetryTimes:Int,private val retryDelayMillis: Int)
    :Function<Observable<out Throwable>, Observable<*>>{

    private var retryTime = 0

    init {
        this.retryTime = 0
    }

    @Throws(Exception::class)
    override fun apply(t: Observable<out Throwable>): Observable<Any>? {
        return t.flatMap { throwable ->
            if(++retryTime <= maxRetryTimes){
                Log.i("RetryWithDelay", "网络连接失败..重试中:次数$retryTime")
                Observable.timer(retryDelayMillis.toLong(),TimeUnit.MILLISECONDS)
            }else{
                Observable.error<Any>(throwable)
            }
        }
    }




}