package com.wind.poem.ui.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.annotation.CheckResult
import com.trello.rxlifecycle2.LifecycleProvider
import com.trello.rxlifecycle2.LifecycleTransformer
import com.trello.rxlifecycle2.RxLifecycle
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject

/**
 * Created by Jiwei Yuan on 18-7-11.
 */
abstract class BaseLifecyclePresenter<E> : LifecycleProvider<E> {

    protected val lifecycleSubject = BehaviorSubject.create<E>()

    @CheckResult
    override fun lifecycle(): Observable<E> {
        return lifecycleSubject
    }


    @CheckResult
    override fun <T : Any?> bindUntilEvent(event: E): LifecycleTransformer<T> {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event)
    }


    @CheckResult
    override fun <T : Any?> bindToLifecycle(): LifecycleTransformer<T> {
        //TODO
        return RxLifecycle.bind(lifecycleSubject)
    }
}