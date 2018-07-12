package com.wind.poem

import android.app.Application
import com.baidu.mapapi.SDKInitializer
import com.wind.poem.utils.ApplicationProvider

class PoemApp : Application() {
    override fun onCreate() {
        super.onCreate()
        SDKInitializer.initialize(this@PoemApp)
        ApplicationProvider.attachApplication(this@PoemApp)
    }
}
