package com.wind.poem

import android.app.Application
import com.baidu.mapapi.SDKInitializer

class PoemApp :Application(){
    override fun onCreate() {
        super.onCreate()
        SDKInitializer.initialize(this@PoemApp)
    }
}
