package com.fxy.lib.network

import com.fxy.lib.config.BASE_URL
import com.exam.lib_common.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * create by:Fxymine4ever
 * time: 2019/1/31
 */
object ApiGenerator {
    private const val TIME_OUT = 30
    private var retrofit: Retrofit
    private var okHttpClient: OkHttpClient
    private var builder: OkHttpClient.Builder = OkHttpClient.Builder()

    init {
        builder.connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(logging)
        }
        okHttpClient = builder.build()
        retrofit = buildRetrofit(BASE_URL)
    }

    fun buildRetrofit(baseUrl: String) = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun <T> getApiService(clazz: Class<T>) = retrofit.create(clazz)

    fun <T> getApiService(retrofit: Retrofit, clazz: Class<T>) = retrofit.create(clazz)
}