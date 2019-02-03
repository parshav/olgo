package com.pv.base

import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable
import org.koin.dsl.module.module

sealed class BottomNavFeature {
    object Announcements : BottomNavFeature()
    object Polls : BottomNavFeature()
}

class BottomNavHandler : BottomNavigationView.OnNavigationItemSelectedListener {

    private val bottomSelectedRelay = BehaviorRelay.create<BottomNavFeature>()

    fun bottomSelectedObservable(): Observable<BottomNavFeature> = bottomSelectedRelay

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.action_announcements -> {
                bottomSelectedRelay.accept(BottomNavFeature.Announcements)
            }
            R.id.action_polls -> {
                bottomSelectedRelay.accept(BottomNavFeature.Polls)
            }
        }
        return true
    }
}

val bottomNavHandlerModule = module {
    factory { BottomNavHandler() }
}