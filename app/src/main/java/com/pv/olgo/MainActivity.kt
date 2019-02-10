package com.pv.olgo

import android.annotation.SuppressLint
import android.os.Bundle
import com.pv.base.BaseActivity
import com.pv.base.ui
import org.koin.android.ext.android.setProperty

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

    override fun onCreate(savedInstanceState: Bundle?) {

        setProperty("selected_id", R.id.action_polls)
        super.onCreate(savedInstanceState)
    }
}
