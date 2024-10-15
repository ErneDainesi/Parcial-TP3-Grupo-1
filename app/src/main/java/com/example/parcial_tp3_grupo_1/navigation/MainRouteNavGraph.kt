package com.example.parcial_tp3_grupo_1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailRoute
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailScreen
import com.example.parcial_tp3_grupo_1.screens.product.ProductDetailViewModel
import com.example.parcial_tp3_grupo_1.screens.signin.SignInRoute
import com.example.parcial_tp3_grupo_1.screens.signup.SignUpRoute
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService

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

        val service = FakeStoreService(FakeStoreHelper())

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
//            SignUpRoute(navigationActions = navigationActions)
            ProductDetailRoute(
                productId = 1,
                navigationActions = navigationActions,
                viewModel = ProductDetailViewModel(service)
            )
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
//        composable(route = AppDestinations.PROD_DETAIL_ROUTE) {
//            ProductDetailRoute(productId = 1, navigationActions = navigationActions)
//        }
        composable(
            route = AppDestinations.PROD_DETAIL_ROUTE
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("id")
            productId?.let {
                ProductDetailRoute(
                    productId = productId.toInt(),
                    navigationActions = navigationActions,
                    viewModel = ProductDetailViewModel(service)
                )
            }
        }
    }
}