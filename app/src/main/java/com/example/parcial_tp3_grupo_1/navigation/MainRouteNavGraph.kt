package com.example.parcial_tp3_grupo_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial_tp3_grupo_1.screens.home.HomeRoute
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailRoute
import com.example.parcial_tp3_grupo_1.screens.signin.SignInRoute
import com.example.parcial_tp3_grupo_1.screens.signup.SignUpRoute

@Composable
fun MainRouteNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = AppDestinations.SIGNIN_ROUTE,
    navigationActions: MainNavActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {


        composable(route = AppDestinations.SHOP_ROUTE) {
            HomeRoute(navActions = navigationActions)
        }
        composable(route = AppDestinations.EXPLORE_ROUTE) {
            // Just for testing, here we need to add the Explore Route
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
            // Just for testing, here we need to add the Account Route
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.SIGNIN_ROUTE) {
            SignInRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.SIGNUP_ROUTE) {
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(
            route = AppDestinations.PROD_DETAIL_ROUTE
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("id")
            productId?.let {
                ProductDetailRoute(
                    productId = productId.toInt(),
                    navigationActions = navigationActions,
                )
            }
        }
    }
}