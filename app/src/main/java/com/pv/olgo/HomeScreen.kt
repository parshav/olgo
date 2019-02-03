package com.pv.olgo

import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pv.base.BaseScreen
import com.pv.base.BottomNavHandler
import org.koin.android.ext.android.inject

class HomeScreen : BaseScreen() {

    private val bottomNavHandler: BottomNavHandler by inject()

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun layout() = R.layout.screen_home

    override fun onViewLoaded(view: View) {
        bottomNavigationView = view.findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavHandler)
    }

    override fun screenOnStart() = arrayOf(
        bottomNavHandler.bottomSelectedObservable().subscribe {

        }
    )
}