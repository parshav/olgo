package com.pv.olgo

import android.app.Application
import com.pv.base.activityHelperModule
import com.pv.base.bottomNavHandlerModule
import com.pv.base.navigatorModule
import com.pv.firebase.announcementsRequestModule
import com.pv.firebase.firebaseModule
import com.pv.olgo.announcements.announcementsAdapterModule
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
                announcementsRequestModule,
                announcementsAdapterModule
            )
        )
    }
}