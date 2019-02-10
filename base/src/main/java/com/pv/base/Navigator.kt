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
    }
}

val navigatorModule = module {
    single<NavigatorTemplate> { GlobalNavigator(get()) }
}