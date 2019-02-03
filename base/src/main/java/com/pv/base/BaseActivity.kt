package com.pv.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {


//    private val homeScreen by lazy { Flutter.createFragment("route1") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState.onNull {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fl_container, screen())
                .commitNow()
        }
    }

    abstract fun screen(): Screen
}

typealias Screen = Fragment

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}