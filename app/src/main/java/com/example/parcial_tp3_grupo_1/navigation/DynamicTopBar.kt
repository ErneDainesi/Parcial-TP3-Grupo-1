package com.example.parcial_tp3_grupo_1.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

object TopBar {
    const val HOME_SCREEN = "shop"
    const val EXPLORE_SCREEN = "explore"
    const val CART_SCREEN = "cart"
    const val FAVORITE_SCREEN = "favorite"
    const val ACCOUNT_SCREEN = "account"
    const val PRODUCT_DETAIL_SCREEN = "product detail"
    const val CATEGORIES_SCREEN = "categories"
    const val SEARCH_SCREEN = "search"
}

val showTopBar = listOf(
    TopBar.HOME_SCREEN,
    TopBar.EXPLORE_SCREEN,
    TopBar.CART_SCREEN,
    TopBar.FAVORITE_SCREEN,
    TopBar.ACCOUNT_SCREEN,
    TopBar.PRODUCT_DETAIL_SCREEN,
    TopBar.CATEGORIES_SCREEN,
    TopBar.SEARCH_SCREEN,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopBar(
    location: String?,
    onNavigationClick: (() -> Unit)? = null
) {
    if (location != null && topBarShouldShow(location)) {
        val title = when (location) {
            TopBar.HOME_SCREEN -> "Shop"
            TopBar.EXPLORE_SCREEN -> "Find Products"
            TopBar.CART_SCREEN -> "My Cart"
            TopBar.FAVORITE_SCREEN -> "Favorites"
            TopBar.ACCOUNT_SCREEN -> "Account"
            TopBar.PRODUCT_DETAIL_SCREEN -> "Product Detail"
            TopBar.CATEGORIES_SCREEN -> "Categories"
            TopBar.SEARCH_SCREEN -> "Search"
            else -> "Shop"
        }
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black,
            ),
            title = {
                Text(text = title)
            },
            navigationIcon = {
                IconButton(onClick = { onNavigationClick?.invoke() }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.Black)
                }
            },
        )
    }
}

@Composable
fun topBarShouldShow(location: String?): Boolean {
    return showTopBar.contains(location)
}