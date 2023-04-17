package com.orafaelsc.composeplayground.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.orafaelsc.composeplayground.R

@Composable
fun RootNavigationGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = AppGraph.initial.ROOT,
        startDestination = AppGraph.auth.ROOT
    ) {
        authNavGraph(navController = navController)
        composable(route = AppGraph.home.ROOT) {
            ViewContent()
        }
    }
}

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = AppGraph.auth.ROOT,
        startDestination = AppGraph.auth.TO_LOGIN
    ) {
        composable(route = AppGraph.auth.TO_LOGIN) {
            LoginContent(
                onLoginClick = {
                    navController.popBackStack()
                    navController.navigate(AppGraph.home.ROOT)
                },
                onSignUpClick = { navController.navigate(AppGraph.auth.TO_SIGN_UP) },
                onForgotClick = { navController.navigate(AppGraph.auth.TO_FORGOT_PASSWORD) }
            )
        }
        composable(route = AppGraph.auth.TO_SIGN_UP) {
            ViewContent(name = stringResource(id = R.string.sign_up)) {}
        }
        composable(route = AppGraph.auth.TO_FORGOT_PASSWORD) {
            ViewContent(name =  stringResource(id = R.string.forgot_password)) {}
        }
    }
}


@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = AppGraph.home.ROOT,
        startDestination = AppGraph.home.TO_HOME
    ) {
        composable(route = AppGraph.home.TO_HOME) {
            ViewContent(
                name = stringResource(id = R.string.home),
                onClick = {
                    navController.navigate(AppGraph.details.ROOT)
                }
            )
        }
        composable(route = AppGraph.home.TO_PROFILE) {
            ViewContent(
                name = stringResource(id = R.string.profile),
                onClick = { }
            )
        }
        composable(route = AppGraph.home.TO_SETTINGS) {
            ViewContent(
                name = stringResource(id = R.string.settings),
                onClick = { }
            )
        }
        detailsNavGraph(navController = navController)
    }
}



fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = AppGraph.details.ROOT,
        startDestination = AppGraph.details.TO_HELP
    ) {
        composable(route = AppGraph.details.TO_HELP) {
            ViewContent(name = stringResource(R.string.help)) {
                navController.navigate(AppGraph.details.TO_DISCLAIMER)
            }
        }
        composable(route = AppGraph.details.TO_DISCLAIMER) {
            ViewContent(name = stringResource(R.string.disclaimer)) {
                navController.navigate(AppGraph.details.TO_FAQ)
            }
        }
        composable(route = AppGraph.details.TO_FAQ) {
            ViewContent(name = stringResource(R.string.faq)) {
                navController.popBackStack(
                    route = AppGraph.details.TO_FAQ,
                    inclusive = false
                )
            }
        }
    }
}