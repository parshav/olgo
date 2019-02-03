package com.pv.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject

abstract class BaseActivity : AppCompatActivity() {


    //    private val homeScreen by lazy { Flutter.createFragment("route1") }
    private val activityHelper: ActivityHelper by inject()
    private val ui by lazy { uiBuilder() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.layout ?: R.layout.activity_main)

        activityHelper.setLifecycle(lifecycle)

        savedInstanceState.onNull {
            supportFragmentManager
                .beginTransaction()
                .replace(ui.container ?: R.id.fl_container, ui.screen ?: Screen())
                .commitNow()
        }
    }

    abstract fun uiBuilder(): UI
}

class UI {

    var container: Int? = null
    var layout: Int? = null
    var screen: Screen? = null
}


fun ui(block: UI.() -> Unit): UI {
    val u = UI()
    u.block()
    return u
}

typealias Screen = Fragment

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}