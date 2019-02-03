package com.pv.olgo

import android.annotation.SuppressLint
import com.pv.base.BaseActivity
import com.pv.base.UI
import com.pv.base.ui

@SuppressLint("Registered")
class MainActivity : BaseActivity() {

    override fun uiBuilder(): UI = ui {
        layout = R.layout.activity_main
        container = R.id.fl_container
        screen = HomeScreen()
    }
}
