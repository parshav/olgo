package com.pv.olgo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking


abstract class BaseScreen : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View = inflater.inflate(layout(), container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewLoaded(view)
    }

    override fun onStart() {
        super.onStart()
        screenOnStart()
    }

    override fun onStop() {
        super.onStop()
        screenOnStop()
    }

    suspend fun hello() {
    }

    @LayoutRes
    abstract fun layout(): Int

    abstract fun onViewLoaded(view: View)
    abstract fun screenOnStart()

    open fun screenOnStop() {

    }
}
