package com.pv.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import io.reactivex.disposables.Disposable


abstract class BaseScreen : Fragment() {

    private val disposable: MutableList<Disposable> = mutableListOf()
    private val ui by lazy { ui() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(ui.layout ?: 0, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onViewLoaded(view)
    }

    override fun onStart() {
        super.onStart()
        disposable.addAll(screenOnStart())
    }

    override fun onStop() {
        super.onStop()
        screenOnStop()
        disposable.forEach { it.dispose() }
    }

    abstract fun ui(): Screen

    abstract fun onViewLoaded(view: View)
    abstract fun screenOnStart(): Array<Disposable>

    open fun screenOnStop() {

    }
}

class Screen {
    var layout: Int? = null
}

fun screen(block: Screen.() -> (Unit)): Screen {
    val screen = Screen()
    screen.block()
    return screen
}