package com.pv.base

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import org.koin.dsl.module.module

interface ActivityHelper {

    fun setLifecycle(lifecycle: Lifecycle)
}

class GlobalActivityHelper : ActivityHelper, LifecycleObserver {

    override fun setLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        log("On Resume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        log("On Create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        log("On Pause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        log("On Destroy")
    }
}

val activityHelperModule = module {
    single<ActivityHelper> { GlobalActivityHelper() }
}
