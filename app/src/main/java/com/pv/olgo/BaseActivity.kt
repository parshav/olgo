package com.pv.olgo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import io.flutter.facade.Flutter

abstract class BaseActivity : AppCompatActivity() {


//    private val homeScreen by lazy { HomeScreen() }
    private val homeScreen by lazy { Flutter.createFragment("route1") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, homeScreen)
            .commitNow()
    }
}

typealias Screen = Fragment

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}