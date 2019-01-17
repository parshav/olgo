package com.pv.olgo

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var router: Router

    private val homeScreen by lazy { HomeScreen() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<ViewGroup>(R.id.controller_container)

        router = Conductor.attachRouter(this, container, savedInstanceState)

        router.setRoot(RouterTransaction.with(homeScreen))
    }

//    abstract fun screen(): Screen
}

typealias Screen = Controller

fun <T> T?.onNull(block: () -> (Unit)) {
    if (this == null)
        block.invoke()
}