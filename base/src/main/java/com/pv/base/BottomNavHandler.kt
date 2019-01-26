package com.pv.base

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.dsl.module.module

class BottomNavHandler : BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_announcements -> {
            }
            R.id.action_polls -> {
            }
        }
        return true
    }
}

val bottomNavHandlerModule = module {
    factory { BottomNavHandler() }
}