package ru.popkov.transport.timer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.popkov.transport.timer.ui.components.TabItem
import ru.popkov.transport.timer.ui.screens.ProfileScreen
import ru.popkov.transport.timer.ui.screens.SettingsScreen

fun NavGraphBuilder.settingsNavGraph(actions: NavigationActions) {
    navigation(route = TabItem.SettingsTab.route, startDestination = Screens.Settings.route) {
        composable(Screens.Settings.route) {
            SettingsScreen(onProfileSelected = {
                actions.navigateTo(Screens.ProfileSettings.route)
            }, onBackPressed = {
                actions.newRootScreen(Screens.Settings.route)
            })
        }
        composable(Screens.ProfileSettings.route) {
            ProfileScreen()
        }
    }
}