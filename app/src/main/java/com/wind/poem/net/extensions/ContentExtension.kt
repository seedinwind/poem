package com.wind.poem.net.extensions

import com.wind.poem.models.Poem
import com.wind.poem.net.ErrorConsumer
import com.wind.poem.net.ErrorListener
import com.wind.poem.net.NextConsumer
import com.wind.poem.net.NextListener
import com.wind.poem.net.business.ContentRepository

/**
 * Created by Jiwei Yuan on 18-7-3.
 */

fun getPoemsByAuthor(author: String, onNext: NextListener<List<Poem>>, onError: ErrorListener) {
    ContentRepository().getPoemsByAuthor(author, NextConsumer(onNext, onError), ErrorConsumer(onError))
}