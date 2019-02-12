package com.pv.olgo

import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pv.base.*
import com.pv.olgo.announcements.AnnouncementsScreen
import io.flutter.facade.Flutter
import org.koin.android.ext.android.getKoin
import org.koin.android.ext.android.inject

class HomeScreen : BaseScreen() {

    override fun ui() = screen {
        layout = R.layout.screen_home
    }

    private val bottomNavHandler: BottomNavHandler by inject()
    private val navigator: NavigatorTemplate by inject()

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onViewLoaded(view: View) {
        bottomNavigationView = view.findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavHandler)

        bottomNavigationView.selectedItemId = getKoin().getProperty("selected_id")
    }

    override fun bindings() = arrayOf(
        bottomNavHandler.bottomSelectedObservable().subscribe {
            when (it) {
                BottomNavFeature.Announcements -> {
                    navigator.bottomTabNavigate(AnnouncementsScreen())
                }
                BottomNavFeature.Polls -> {
                    navigator.bottomTabNavigate(PollsScreen())
                }
                BottomNavFeature.Flutter -> {
                    navigator.bottomTabNavigate(Flutter.createFragment("route1"))
                }
            }
        }
    )
}