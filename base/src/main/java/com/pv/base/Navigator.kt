package com.pv.base

import androidx.fragment.app.Fragment
import org.koin.dsl.module.module

interface NavigatorTemplate {

    var activityHelper: ActivityHelper

    fun navigateTo(screen: Fragment, type: NavigationType = NavigationType.Screen)
}

class GlobalNavigator(
    override var activityHelper: ActivityHelper
) : NavigatorTemplate {

    override fun navigateTo(screen: Fragment, type: NavigationType) {
        activityHelper.getFragmentManager()
            .beginTransaction()
            .replace(if (type == NavigationType.Screen) R.id.home_container else R.id.fl_container, screen)
            .commit()
    }
}

enum class NavigationType {
    Screen, Modal
}

val navigatorModule = module {
    single<NavigatorTemplate> { GlobalNavigator(get()) }
}