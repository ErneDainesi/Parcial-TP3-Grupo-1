package com.example.parcial_tp3_grupo_1.navigation

import androidx.navigation.NavHostController

object AppDestinations {
    const val ACCOUNT_ROUTE = "account"
    const val CART_ROUTE = "cart"
    const val EXPLORE_ROUTE = "explore"
    const val FAVORITE_ROUTE = "favorite"
    const val SHOP_ROUTE = "shop"
    const val SIGNIN_ROUTE = "signin"
    const val SIGNUP_ROUTE = "signup"
    const val SPLASH_ROUTE = "splash"
    const val ONBOARDING_ROUTE = "onboarding"
}

val hideBottomBar = listOf(
    AppDestinations.SIGNUP_ROUTE,
    AppDestinations.SIGNIN_ROUTE,
    AppDestinations.SPLASH_ROUTE,
    AppDestinations.ONBOARDING_ROUTE
)

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
    val navigateToSignIn: () -> Unit = {
        navController.navigate(AppDestinations.SIGNIN_ROUTE)
    }
    val navigateToSignUp: () -> Unit = {
        navController.navigate(AppDestinations.SIGNUP_ROUTE)
    }
    val navigateToOnboarding: () -> Unit = {
        navController.navigate(AppDestinations.ONBOARDING_ROUTE)
    }

    fun shouldHideBottombar(location: String?): Boolean {
        return hideBottomBar.contains(location)
    }
}