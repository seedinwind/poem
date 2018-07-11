package com.wind.poem.ui.presenter

import com.wind.poem.models.Poem
import com.wind.poem.net.ErrorListener
import com.wind.poem.net.NextListener
import com.wind.poem.net.extensions.getPoemsByAuthor

/**
 * Created by Jiwei Yuan on 18-7-11.
 */

class TestPresenter() : ActivityLifecyclePresenter() {

    fun fetchPoemByAuthor() {
        getPoemsByAuthor(this@TestPresenter, "李白",
                object : NextListener<List<Poem>>() {
                    override fun onDataSuccess(data: List<Poem>) {
                    }
                },
                object : ErrorListener() {
                    override fun httpError(code: Int) {
                    }
                })
    }
}