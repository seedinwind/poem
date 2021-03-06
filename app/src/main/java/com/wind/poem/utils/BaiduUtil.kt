package com.wind.poem.utils

import android.graphics.Color
import android.widget.TextView
import com.baidu.mapapi.map.*
import com.baidu.mapapi.model.LatLng

/**
 * Created by Jiwei Yuan on 18-7-13.
 */

object BaiduUtil {
    /**
     *创建点坐标覆盖物
     */
    fun createAddressOverlay(lat: Double, lng: Double, icon: Int): MarkerOptions {
        return MarkerOptions()
                .position(LatLng(lat, lng))
                .icon(BitmapDescriptorFactory.fromResource(icon))
    }

    /**
     * 創建中心點位置信息
     */
    fun createMapStatus(lat: Double, lng: Double, zoom: Float): MapStatusUpdate {
        return MapStatusUpdateFactory.newMapStatus(
                MapStatus.Builder()
                        .target(LatLng(lat, lng))
                        .zoom(zoom)
                        .build())
    }

    fun createPopInfo(lat: Double, lng: Double, info: String): InfoWindow {
        val textView = TextView(ApplicationProvider.provide())
        textView.setTextColor(Color.BLACK)
        textView.text = info
        return InfoWindow(textView, LatLng(lat, lng), -47)
    }

}