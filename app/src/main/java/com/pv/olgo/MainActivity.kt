package com.pv.olgo

import android.annotation.SuppressLint
import com.pv.base.BaseActivity
import com.pv.base.ui

/*val mainActivityUI = module {
    scope("main_activity") {
        single {
            ui {
                layout = R.layout.activity_main
                container = R.id.fl_container
                screen = HomeScreen()
            }
        }
    }
}*/

@SuppressLint("Registered")
class MainActivity : BaseActivity() {

//    override fun uiBuilder(): UI = get()

    override fun uiBuilder() = ui {
        layout = R.layout.activity_main
        container = R.id.fl_container
        screen = HomeScreen()
    }
}
