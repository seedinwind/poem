package com.wind.poem.widget

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.util.Range
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.wind.poem.R

class PoemImageView : FrameLayout {
    constructor(context: Context, attrs: AttributeSet?, defaultStyle: Int) : super(context, attrs, defaultStyle) {
        initView()
    }
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    private fun initView() {
         LayoutInflater.from(context).inflate(R.layout.widget_poem_image,this)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        for(i in 0..(childCount-1)){
            getChildAt(i).measure(widthMeasureSpec,heightMeasureSpec)
        }

        setMeasuredDimension(getChildAt(0).measuredWidth,
               getChildAt(0).measuredHeight)
    }

}