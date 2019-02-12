package com.pv.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject


abstract class BaseActivity : AppCompatActivity() {


    private val activityHelper: ActivityHelper by inject()
    private val navigatorTemplate: NavigatorTemplate by inject()

    private val ui by lazy { uiBuilder() }
    private val uii by inject<UI>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.layout ?: R.layout.activity_main)

        activityHelper.setLifecycle(lifecycle)
        activityHelper.setFragmentManager(supportFragmentManager)

        savedInstanceState.onNull {
            supportFragmentManager
                .beginTransaction()
                .replace(ui.container ?: R.id.fl_container, ui.screen ?: Fragment())
                .commitNow()
        }
    }

    abstract fun uiBuilder(): UI

    override fun onBackPressed() {
        if (!navigatorTemplate.pop()) {
            super.onBackPressed()
        }
    }
}

class UI {

    var container: Int? = null
    var layout: Int? = null
    var screen: Fragment? = null
}


fun ui(block: UI.() -> Unit): UI {
    val u = UI()
    u.block()
    return u
}

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}

/*
val uiModule = module {
    scope("activity") { UI() }
}*/
