package com.wind.poem.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Jiwei Yuan on 18-7-3.
 */

object RetrofitUtil {
    val instance :Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl("http://47.94.95.216")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .callFactory(OkHttpUtil.instance)
                .build()
    }
}

object OkHttpUtil {
    val instance:OkHttpClient by lazy {
        OkHttpClient.Builder()
                .connectTimeout(30,TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30,TimeUnit.SECONDS)
                .build()
    }
}