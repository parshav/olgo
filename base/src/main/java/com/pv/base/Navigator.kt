package com.pv.base

import androidx.fragment.app.Fragment
import org.koin.dsl.module.module

interface NavigatorTemplate {

    var activityHelper: ActivityHelper

    fun navigateTo(screen: Fragment, type: NavigationType = NavigationType.Screen)
    fun bottomTabNavigate(screen: Fragment)
    fun pop(): Boolean
}

internal class GlobalNavigator(
    override var activityHelper: ActivityHelper
) : NavigatorTemplate {

    override fun bottomTabNavigate(screen: Fragment) {
        activityHelper.getFragmentManager()
            .beginTransaction()
            .replace(R.id.home_container, screen)
            .commit()
    }

    override fun navigateTo(screen: Fragment, type: NavigationType) {
        activityHelper.getFragmentManager()
            .beginTransaction()
            .setCustomAnimations(R.anim.abc_slide_in_bottom, R.anim.abc_fade_out, R.anim.abc_fade_in, R.anim.abc_slide_out_bottom)
            .replace(if (type == NavigationType.Screen) R.id.home_container else R.id.fl_container, screen)
            .addToBackStack(null)
            .commit()
    }

    override fun pop(): Boolean {

        return if (activityHelper.getFragmentManager().backStackEntryCount > 0) {
            activityHelper.getFragmentManager()
                .popBackStackImmediate()
            true
        } else {
            false
        }
    }
}

enum class NavigationType {
    Screen, Modal
}

val navigatorModule = module {
    single<NavigatorTemplate> { GlobalNavigator(get()) }
}