package com.example.parcial_tp3_grupo_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial_tp3_grupo_1.screens.signin.SignInRoute
import com.example.parcial_tp3_grupo_1.screens.signup.SignUpRoute

@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SHOP_ROUTE,
    navigationActions: MainNavActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = AppDestinations.SHOP_ROUTE) {
            // Just for testing, here we need to add the Shop Route
            SignInRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.EXPLORE_ROUTE) {
            // Just for testing, here we need to add the Cart Route
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.CART_ROUTE) {
            // Just for testing, here we need to add the Cart Route
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.FAVORITE_ROUTE) {
            // Just for testing, here we need to add the Cart Route
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.ACCOUNT_ROUTE) {
            // Just for testing, here we need to add the Cart Route
            SignUpRoute(navigationActions = navigationActions)
        }
    }
}