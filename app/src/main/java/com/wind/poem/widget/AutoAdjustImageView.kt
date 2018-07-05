package com.wind.poem.widget

import android.content.Context
import android.hardware.display.DisplayManager
import android.util.AttributeSet
import android.view.WindowManager
import android.widget.ImageView
import android.util.DisplayMetrics
import android.util.Log


class AutoAdjustImageView : ImageView {
    constructor(context: Context, attrs: AttributeSet?, defaultStyle: Int) : super(context, attrs, defaultStyle)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)
    val dm = DisplayMetrics()
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        (context.getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getMetrics(dm)
        Log.i("--",dm.widthPixels.toString())
        setMeasuredDimension(MeasureSpec.makeMeasureSpec(dm.widthPixels, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(drawable.intrinsicHeight * dm.widthPixels/ drawable.intrinsicWidth , MeasureSpec.EXACTLY))
    }

}