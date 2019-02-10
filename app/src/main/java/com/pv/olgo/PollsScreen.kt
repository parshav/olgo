package com.pv.olgo

import android.view.View
import com.pv.base.BaseScreen
import com.pv.base.screen
import io.reactivex.disposables.Disposable

class PollsScreen : BaseScreen() {

    override fun ui() = screen {
        layout = R.layout.screen_polls
    }

    override fun onViewLoaded(view: View) {
    }

    override fun bindings(): Array<Disposable> = arrayOf()

}