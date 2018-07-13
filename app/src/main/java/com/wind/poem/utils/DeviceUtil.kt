package com.wind.poem.utils

import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * 设备信息相关
 * Created by Jiwei Yuan on 18-7-12.
 */
object DeviceUtil {

    var screenDemin: Array<Int>? = null

    fun getScreenDemesion(): Array<Int> {
        if (screenDemin != null) {
            return screenDemin!!
        }
        val service = ApplicationProvider.provide().getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val matrix = DisplayMetrics()
        service.defaultDisplay.getMetrics(matrix)
        return arrayOf(matrix.widthPixels, matrix.heightPixels)
    }

    fun getBrand(): String {
        return Build.BRAND
    }

    fun getAndroidVersion(): Int {
        return Build.VERSION.SDK_INT
    }


}