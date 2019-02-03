package com.pv.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment


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

    @LayoutRes
    abstract fun layout(): Int

    abstract fun onViewLoaded(view: View)
    abstract fun screenOnStart()

    open fun screenOnStop() {

    }
}
