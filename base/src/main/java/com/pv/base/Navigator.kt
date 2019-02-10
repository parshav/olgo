package com.pv.base

import androidx.fragment.app.Fragment
import org.koin.dsl.module.module

interface NavigatorTemplate {

    var activityHelper: ActivityHelper

    fun navigateTo(screen: Fragment)
}

class GlobalNavigator(
    override var activityHelper: ActivityHelper
) : NavigatorTemplate {

    override fun navigateTo(screen: Fragment) {
        activityHelper.getFragmentManager()
            .beginTransaction()
            .replace(R.id.home_container, screen)
            .commit()
    }
}

val navigatorModule = module {
    single<NavigatorTemplate> { GlobalNavigator(get()) }
}