package com.pv.olgo

import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pv.base.BaseScreen

class HomeScreen : BaseScreen() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun layout() = R.layout.screen_home

    override fun onViewLoaded(view: View) {
        bottomNavigationView = view.findViewById(R.id.bottom_nav)
    }

    override fun screenOnStart() {

    }
}