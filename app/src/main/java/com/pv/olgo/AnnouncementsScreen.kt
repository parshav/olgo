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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindings(): Array<Disposable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}