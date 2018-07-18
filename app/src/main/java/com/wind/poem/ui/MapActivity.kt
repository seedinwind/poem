package com.wind.poem.ui

import android.os.Bundle
import com.baidu.mapapi.map.BaiduMap
import com.baidu.mapapi.map.Marker
import com.blankj.utilcode.util.ToastUtils
import com.wind.poem.R
import com.wind.poem.R.id.bmapView
import com.wind.poem.utils.BaiduUtil
import kotlinx.android.synthetic.main.act_map.*

/**
 * Created by Jiwei Yuan on 18-7-4.
 */

class MapActivity : BaseActivity() {

    private lateinit var mBaiduMap: BaiduMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_map)
        mBaiduMap = bmapView.map
        mBaiduMap.addOverlay(BaiduUtil.createAddressOverlay(30.084277, 103.859729, R.mipmap.home))
        mBaiduMap.setMapStatus(BaiduUtil.createMapStatus(30.084277, 103.859729, 10f))
        mBaiduMap.showMapPoi(false)
        mBaiduMap.setOnMarkerClickListener (object :BaiduMap.OnMarkerClickListener{
            override fun onMarkerClick(marker: Marker?): Boolean {
                mBaiduMap.showInfoWindow(BaiduUtil.createPopInfo(30.084277,103.859729,"苏轼于宋仁宗景佑三年(1037年1月8日)\n 出生于眉州眉山\n是初唐大臣苏味道之后"))
                return true
            }
        })
    }
}