package com.pv.base

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import org.koin.dsl.module.module

interface ActivityHelper {

    fun setLifecycle(lifecycle: Lifecycle)

    fun setFragmentManager(fragmentTransaction: FragmentManager)

    fun getFragmentManager(): FragmentManager
}

class GlobalActivityHelper : ActivityHelper, LifecycleObserver {

    private lateinit var fragmentManager: FragmentManager

    override fun setLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    override fun setFragmentManager(fragmentTransaction: FragmentManager) {
        this.fragmentManager = fragmentTransaction
    }

    override fun getFragmentManager(): FragmentManager = fragmentManager

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
