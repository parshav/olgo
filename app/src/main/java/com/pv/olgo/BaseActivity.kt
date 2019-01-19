package com.pv.olgo

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity : AppCompatActivity() {


    private val homeScreen by lazy { HomeScreen() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<ViewGroup>(R.id.controller_container)
    }

//    abstract fun screen(): Screen
}

typealias Screen = Fragment

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}