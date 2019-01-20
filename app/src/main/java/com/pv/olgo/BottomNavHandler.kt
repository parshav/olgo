package com.pv.olgo

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView

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