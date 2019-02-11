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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bindings(): Array<Disposable> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}