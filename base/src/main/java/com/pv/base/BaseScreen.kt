package com.pv.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


abstract class BaseScreen : Fragment() {

    private val jobs: MutableList<Job> = mutableListOf()

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
        runBlocking {
            screenOnStart()
        }
    }

    override fun onStop() {
        super.onStop()
        jobs.forEach { it.cancel() }
        screenOnStop()
    }

    @LayoutRes
    abstract fun layout(): Int

    abstract fun onViewLoaded(view: View)
    abstract fun screenOnStart()

    open fun screenOnStop() {

    }
}
