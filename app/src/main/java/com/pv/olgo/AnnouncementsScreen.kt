package com.pv.olgo

import android.view.View
import com.pv.base.BaseScreen
import com.pv.base.Screen
import com.pv.base.log
import com.pv.base.screen
import com.pv.firebase.RequestAnnouncements
import io.reactivex.disposables.Disposable
import org.koin.android.ext.android.inject

class AnnouncementsScreen : BaseScreen() {

    private val announcementsRequester: RequestAnnouncements by inject()

    override fun ui() = screen {
        layout = R.layout.screen_announcements
    }

    override fun onViewLoaded(view: View) {
    }

    override fun bindings(): Array<Disposable> = arrayOf(
        announcementsRequester.getAnnouncements().subscribe {
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