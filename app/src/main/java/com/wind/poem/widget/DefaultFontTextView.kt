package com.wind.poem.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import cc.sayaki.widget.PlumbTextView

/**
 * Created by Jiwei Yuan on 18-7-12.
 */
class DefaultFontTextView : PlumbTextView {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private fun initView() {
        setTypeface(Typeface.createFromAsset(context.assets, "oudiexingkai.ttf"))
    }
}