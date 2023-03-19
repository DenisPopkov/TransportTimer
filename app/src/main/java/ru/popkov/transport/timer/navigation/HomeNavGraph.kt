package ru.popkov.transport.timer.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import ru.popkov.transport.timer.ui.components.TabItem
import ru.popkov.transport.timer.ui.screens.HomeScreen

fun NavGraphBuilder.homeNavGraph() {
    navigation(route = TabItem.HomeTab.route, startDestination = Screens.Home.route) {
        composable(Screens.Home.route) {
            HomeScreen()
        }
    }
}