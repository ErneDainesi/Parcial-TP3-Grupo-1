package com.example.parcial_tp3_grupo_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailRoute
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailScreen
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
        composable(route = AppDestinations.SIGNIN_ROUTE) {
            SignInRoute(navigationActions = navigationActions)
        }
        composable(route = AppDestinations.SIGNUP_ROUTE) {
            SignUpRoute(navigationActions = navigationActions)
        }
        composable(
            route = AppDestinations.PROD_DETAIL_ROUTE,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("id")
            productId?.let {
                ProductDetailRoute(productId = productId, navigationActions = navigationActions)
            }
        }
    }
}