package com.wind.poem.utils

import android.content.Context
import com.wind.poem.PoemApp

/**
 * Created by Jiwei Yuan on 18-7-12.
 */

object ApplicationProvider {
    private lateinit var appContext: PoemApp

    fun attachApplication(context: PoemApp) {
        appContext = context
    }

    fun provide(): Context {
        return appContext.applicationContext
    }
}