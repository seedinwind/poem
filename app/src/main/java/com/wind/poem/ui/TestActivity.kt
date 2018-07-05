package com.wind.poem.ui

import android.os.Bundle
import com.wind.poem.R
import kotlinx.android.synthetic.main.test.*

/**
 * Created by Jiwei Yuan on 18-7-5.
 */

class TestActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)
    }

    override fun onResume() {
        super.onResume()
        poemAnimate.poem = "春晓 春眠不觉晓 处处闻啼鸟 夜来风雨声 花落知多少"
        poemAnimate.showPoem()
    }
}