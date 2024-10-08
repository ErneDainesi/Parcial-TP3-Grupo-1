package com.example.parcial_tp3_grupo_1.navigation

import androidx.navigation.NavHostController


object AppDestinations {
    const val ACCOUNT_ROUTE = "account"
    const val CART_ROUTE = "cart"
    const val EXPLORE_ROUTE = "explore"
    const val FAVORITE_ROUTE = "favorite"
    const val SHOP_ROUTE = "shop"
}

class MainNavActions(
    navController: NavHostController,
) {
    val navigateToAccount: () -> Unit = {
        navController.navigate(AppDestinations.ACCOUNT_ROUTE)
    }
    val navigateToCart: () -> Unit = {
        navController.navigate(AppDestinations.CART_ROUTE)
    }
    val navigateToExplore: () -> Unit = {
        navController.navigate(AppDestinations.EXPLORE_ROUTE)
    }
    val navigateToFavorite: () -> Unit = {
        navController.navigate(AppDestinations.FAVORITE_ROUTE)
    }
    val navigateToShop: () -> Unit = {
        navController.navigate(AppDestinations.SHOP_ROUTE)
    }
}