package com.noobaround.mangabrowser.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.noobaround.mangabrowser.ui.screen.GalleriesScreen
import com.noobaround.mangabrowser.ui.screen.LibraryScreen
import com.noobaround.mangabrowser.ui.screen.ReaderScreen
import com.noobaround.mangabrowser.ui.screen.SettingsScreen

@Composable
fun MangaBrowserApp() {
    val navController = rememberNavController()
    val items = listOf(AppDestination.Library, AppDestination.Galleries, AppDestination.Settings)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                items.forEach { destination ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(destination.label) },
                        icon = { Text(destination.iconText) }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Library.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(AppDestination.Library.route) { LibraryScreen(navController) }
            composable(AppDestination.Galleries.route) { GalleriesScreen(navController) }
            composable(AppDestination.Settings.route) { SettingsScreen(navController) }
            composable(AppDestination.Reader.route) { ReaderScreen(navController) }
        }
    }
}

sealed class AppDestination(val route: String, val label: String, val iconText: String) {
    data object Library : AppDestination("library", "书库", "库")
    data object Galleries : AppDestination("galleries", "画廊", "廊")
    data object Settings : AppDestination("settings", "设置", "设")
    data object Reader : AppDestination("reader", "阅读", "读")
}
