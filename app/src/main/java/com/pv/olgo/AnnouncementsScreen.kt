package com.pv.olgo

import android.view.View
import com.pv.base.BaseScreen
import com.pv.base.Screen
import com.pv.base.log
import com.pv.base.screen
import com.pv.firebase.FirebaseHolder
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject

class AnnouncementsScreen : BaseScreen() {

    private val firebase: FirebaseHolder by inject()

    override fun ui(): Screen = screen {
        layout = R.layout.screen_announcements
    }

    override fun onViewLoaded(view: View) {
    }

    override fun bindings(): Array<Disposable> = arrayOf(
        firebase.getAnnouncements().subscribe {
            it.fold(
                {
                    log("Error'd")
                },
                {
                    log("Got Announcements ${it.announcements}")
                }
            )
        }
    )

}