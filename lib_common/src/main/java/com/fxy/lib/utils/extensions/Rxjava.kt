package com.fxy.lib.utils.extensions

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */

fun <T> Observable<T>.setSchedulers(
        subscribeOn: Scheduler = Schedulers.io(),
        unsubscribeOn: Scheduler = Schedulers.io(),
        observeOn: Scheduler = AndroidSchedulers.mainThread()
): Observable<T> =
        subscribeOn(subscribeOn)
                .unsubscribeOn(unsubscribeOn)
                .observeOn(observeOn)

fun <T> Observable<T>.safeSubscribeBy(
        onNext: (T) -> Unit,
        onError: (Throwable) -> Unit,
        onComplete: () -> Unit
) = subscribe(onNext, onError, onComplete)

