package com.wind.poem.net.extensions

import com.wind.poem.models.JsonResult
import com.wind.poem.models.Poem
import com.wind.poem.net.business.ContentRepository
import io.reactivex.functions.Consumer

/**
 * Created by Jiwei Yuan on 18-7-3.
 */

fun getPoemsByAuthor(author: String, onNext: Consumer<JsonResult<List<Poem>>>, onError: Consumer<in Throwable>) {
    ContentRepository().getPoemsByAuthor(author, onNext, onError)
}