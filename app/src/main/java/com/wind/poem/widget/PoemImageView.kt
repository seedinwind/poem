package com.wind.poem.widget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.wind.poem.R
import kotlinx.android.synthetic.main.widget_poem_image.view.*

class PoemImageView : FrameLayout {
    constructor(context: Context, attrs: AttributeSet?, defaultStyle: Int) : super(context, attrs, defaultStyle) {
        initView()
    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.widget_poem_image, this)
    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        for (i in 0..(childCount - 1)) {
            getChildAt(i).measure(widthMeasureSpec, heightMeasureSpec)
        }

        setMeasuredDimension(getChildAt(0).measuredWidth,
                getChildAt(0).measuredHeight)
    }

    fun addPoem(poem: String) {
        poemAnimate.poem = poem
    }

    fun setImage(resId: Int) {
        bgImage.setImageResource(resId)
    }

    fun setImage(bitmap: Bitmap) {
        bgImage.setImageBitmap(bitmap)
    }

    fun startShow() {
        val anim = ObjectAnimator.ofFloat(layer, "alpha", 0f, 1f)
        anim.duration = 2000*2
        anim.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator?) {
                poemAnimate.showPoem()
            }
        })
        anim.start()
    }

}