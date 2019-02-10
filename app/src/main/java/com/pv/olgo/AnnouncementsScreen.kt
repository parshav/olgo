package com.pv.olgo

import android.view.View
import com.pv.base.BaseScreen
import com.pv.base.Screen
import com.pv.base.screen
import io.reactivex.disposables.Disposable

class AnnouncementsScreen : BaseScreen() {
    override fun ui(): Screen = screen {
        layout = R.layout.screen_announcements
    }

    override fun onViewLoaded(view: View) {
    }

    override fun bindings(): Array<Disposable> = arrayOf()

}