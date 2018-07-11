package com.wind.poem.ui

import android.arch.lifecycle.LifecycleObserver
import android.support.v7.app.AppCompatActivity

/**
 * Created by Jiwei Yuan on 18-7-4.
 */
abstract class BaseActivity : AppCompatActivity() {

    fun addLifeCycleObserver(observer: LifecycleObserver) {
        lifecycle.addObserver(observer)
    }
}