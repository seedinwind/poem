package com.wind.poem.widget

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.LinearLayout
import cc.sayaki.widget.PlumbTextView
import com.wind.poem.R
import jp.wasabeef.recyclerview.animators.FadeInAnimator
import kotlinx.android.synthetic.main.widget_poem_animate.view.*

/**
 * Created by Jiwei Yuan on 18-7-5.
 */
class PoemAnimateView : LinearLayout {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?) : this(context, null)

    private val poems: MutableList<String> = mutableListOf()
    private var duration: Long = 2000
    var poem: String = ""
        set(value) {
            splited = value.split(" ")
        }
    private var splited: List<String> = arrayListOf()
    private fun initView() {
        LayoutInflater.from(context).inflate(R.layout.widget_poem_animate, this)
        val layoutMgr = LinearLayoutManager(context)
        layoutMgr.orientation = LinearLayoutManager.HORIZONTAL
        layoutMgr.reverseLayout = true
        recycler.layoutManager = layoutMgr
        val inAnimator = FadeInAnimator()
        inAnimator.addDuration = duration
        inAnimator.setInterpolator(AccelerateDecelerateInterpolator())
        recycler.itemAnimator = inAnimator
    }

    fun showPoem() {
        if (splited.isEmpty())
            return
        recycler.adapter = PoemAdapter()
        recycler.postDelayed({
            addPoemContent()
        }, 500)
    }

    private fun addPoemContent() {
        recycler.postDelayed({
            if (poems.size < splited.size) {
                poems.add(splited[poems.size])
                recycler.adapter.notifyItemInserted(poems.size)
                addPoemContent()
            }
        }, 2000)
    }

    inner class PoemAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
            val item = LayoutInflater.from(context).inflate(R.layout.item_poem, null)
            return PoemViewHolder(item)
        }

        override fun getItemCount(): Int {
            return poems.size
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
            (holder as PoemViewHolder).text.text = poems[position]
        }

    }

    class PoemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: PlumbTextView = itemView.findViewById(R.id.text)
    }
}