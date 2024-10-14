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

object TopBar  {
    const val HOME_SCREEN = "Shop"
    const val EXPLORE_SCREEN = "Find Products"
    const val CART_SCREEN = "My Cart"
    const val FAVORITE_SCREEN = "Favorites"
    const val ACCOUNT_SCREEN = "Account"
    const val PRODUCT_DETAIL_SCREEN = "Product Detail"
    const val CATEGORIES_SCREEN = "Categories"
    const val SEARCH_SCREEN = "Search"
}

val hideTopBar = listOf(
    TopBar.HOME_SCREEN,
    TopBar.EXPLORE_SCREEN,
    TopBar.CART_SCREEN,
    TopBar.FAVORITE_SCREEN,
    TopBar.ACCOUNT_SCREEN,
    TopBar.PRODUCT_DETAIL_SCREEN,
    TopBar.CATEGORIES_SCREEN,
    TopBar.SEARCH_SCREEN
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DynamicTopBar(
    location: String?,
) {
    if (location != null && topBarShouldAppear(location)) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.White,
                titleContentColor = Color.Black,
            ),
            title = {
                Text(text = location)
            },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menu", tint = Color.Black)
                }
            },
        )
    }
}

@Composable
fun topBarShouldAppear(location: String): Boolean {
    return !hideTopBar.contains(location)
}

@Composable
@Preview (showBackground = true)
fun PreviewTopBar() {
    DynamicTopBar(location = "Account")
}