package com.pv.olgo

import android.annotation.SuppressLint
import android.os.Bundle
import com.pv.base.BaseActivity
import com.pv.base.ui
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.setProperty
import org.koin.core.scope.Scope

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

    lateinit var session: Scope

    override fun uiBuilder() = ui {
        layout = R.layout.activity_main
        container = R.id.fl_container
        screen = HomeScreen()
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        setProperty("selected_id", R.id.action_announcements)
        session = getKoin().createScope("main_activity_scope")
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        session.close()
    }
}
