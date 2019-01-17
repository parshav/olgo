package com.pv.olgo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.bluelinelabs.conductor.Controller


abstract class BaseScreen : Controller() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(layout(), container, false)
    }

    @LayoutRes
    abstract fun layout(): Int
}
