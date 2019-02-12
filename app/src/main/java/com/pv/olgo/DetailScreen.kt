package com.pv.olgo

import android.view.View
import com.pv.base.BaseScreen
import com.pv.base.Screen
import com.pv.base.screen
import io.reactivex.disposables.Disposable

class DetailScreen : BaseScreen() {

    override fun ui() = screen {
        layout = R.layout.screen_detail
    }

    override fun onViewLoaded(view: View) {
    }

    override fun bindings(): Array<Disposable> = arrayOf()

}