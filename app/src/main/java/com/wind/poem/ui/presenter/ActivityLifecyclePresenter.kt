package com.wind.poem.ui.presenter

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import com.trello.rxlifecycle2.android.ActivityEvent

/**
 * Created by Jiwei Yuan on 18-7-11.
 */
open class ActivityLifecyclePresenter : BaseLifecyclePresenter<ActivityEvent>(), LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        lifecycleSubject.onNext(ActivityEvent.CREATE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        lifecycleSubject.onNext(ActivityEvent.START)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        lifecycleSubject.onNext(ActivityEvent.RESUME)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY)
    }
}