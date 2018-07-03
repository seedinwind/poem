package com.wind.poem.net.business

import com.wind.poem.models.JsonResult
import com.wind.poem.models.Poem
import com.wind.poem.net.RetrofitUtil
import com.wind.poem.net.service.ContentService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jiwei Yuan on 18-7-3.
 */
object ContentRepository {
    private val service: ContentService by lazy {
        RetrofitUtil.instance.create(ContentService::class.java)
    }

    fun getPoemsByAuthor(author: String, onNext: Consumer<in JsonResult<List<Poem>>>, onError: Consumer<in Throwable>) {
        service.findPoemsByAuthor(author)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError)
    }

}

fun getPoemsByAuthor(author: String, onNext: Consumer<JsonResult<List<Poem>>>, onError: Consumer<in Throwable>) {
    ContentRepository.getPoemsByAuthor(author, onNext, onError)
}