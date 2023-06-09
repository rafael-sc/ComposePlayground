package com.orafaelsc.composeplayground.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.navigation.AppGraph

sealed class BottomBarItemConfig(
    val route: String,
    @StringRes val title: Int,
    val icon: ImageVector
) {
    object Home : BottomBarItemConfig(
        route = AppGraph.home.TO_HOME,
        title = R.string.home,
        icon = Icons.Default.Home
    )

    object Profile : BottomBarItemConfig(
        route = AppGraph.home.TO_PROFILE,
        title = R.string.profile,
        icon = Icons.Default.Person
    )

    object Settings : BottomBarItemConfig(
        route = AppGraph.home.TO_SETTINGS,
        title = R.string.settings,
        icon = Icons.Default.Settings
    )
}

// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// | "List of all route configurations for the bottom navigation bar."  |
// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
object BottomBarConfigList {
    val all = listOf(
        BottomBarItemConfig.Home,
        BottomBarItemConfig.Profile,
        BottomBarItemConfig.Settings,
    )
}

@Composable
fun BottomBar(navController: NavHostController) {
    // check current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val showNavigationItems = BottomBarConfigList.all.any { it.route == currentDestination?.route }
    if (showNavigationItems) {
        BottomNavigation {
            // ++++++++++++++++++++++++++++++++++++++++++
            // | Display the items of the navigation bar|
            // ++++++++++++++++++++++++++++++++++++++++++
            BottomBarConfigList.all.forEach { itemConfig ->
                AddItem(
                    itemConfig = itemConfig,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    itemConfig: BottomBarItemConfig,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        label = {
            Text(text = stringResource(itemConfig.title))
        },
        icon = {
            Icon(
                imageVector = itemConfig.icon,
                contentDescription = stringResource(
                    id = R.string.navigation_icon_description,
                    itemConfig.title
                )
            )
        },
        selected = currentDestination?.hierarchy?.any { it.route == itemConfig.route } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(itemConfig.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}


