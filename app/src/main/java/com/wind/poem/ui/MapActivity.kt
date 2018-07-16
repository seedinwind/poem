package com.wind.poem.ui

import android.os.Bundle
import com.baidu.mapapi.map.BaiduMap
import com.wind.poem.R
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
    }
}