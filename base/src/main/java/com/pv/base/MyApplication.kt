package com.pv.base

import android.app.Application
import com.pv.firebase.announcementsRequestModule
import com.pv.firebase.firebaseModule
import org.koin.android.ext.android.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin(
            this, listOf(
                bottomNavHandlerModule,
                activityHelperModule,
                navigatorModule,
                firebaseModule,
                announcementsRequestModule
            )
        )
    }
}