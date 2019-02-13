package com.pv.olgo

import android.view.View
import android.widget.TextView
import com.pv.base.BaseScreen
import com.pv.base.screen
import io.reactivex.disposables.Disposable

class PollsScreen : BaseScreen() {

    private lateinit var koinText: TextView

    override fun ui() = screen {
        layout = R.layout.screen_polls
    }

    override fun onViewLoaded(view: View) {

        koinText = view.findViewById(R.id.tv_koin)
    }

    override fun bindings(): Array<Disposable> = arrayOf()

}