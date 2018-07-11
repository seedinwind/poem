package com.wind.poem.net.business

import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.android.ActivityEvent
import com.trello.rxlifecycle2.kotlin.bindUntilEvent
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
class ContentRepository {
    companion object {
        private val service: ContentService by lazy {
            RetrofitUtil.instance.create(ContentService::class.java)
        }
    }


    fun getPoemsByAuthor(provider: LifecycleProvider<ActivityEvent>, author: String, onNext: Consumer<in JsonResult<List<Poem>>>, onError: Consumer<in Throwable>) {
        service.findPoemsByAuthor(author)
                .bindUntilEvent(provider,ActivityEvent.DESTROY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(onNext, onError)
    }
}