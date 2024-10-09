package com.example.parcial_tp3_grupo_1.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.data.BottomNavItem
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions

@Composable
fun BottomNavBar(
    navigationActions: MainNavActions
) {
    val navItems = listOf(
        BottomNavItem("Shop", R.drawable.shopicon, navigationActions.navigateToShop),
        BottomNavItem("Explore", R.drawable.exploreicon, navigationActions.navigateToExplore),
        BottomNavItem("Cart", R.drawable.carticon, navigationActions.navigateToCart),
        BottomNavItem("Favorite", R.drawable.favoriteicon, navigationActions.navigateToFavorite),
        BottomNavItem("Account", R.drawable.accounticon, navigationActions.navigateToAccount),
    )

    NavigationBar (
        containerColor = Color.White,
    ) {
        navItems.forEach { item ->
            NavigationBarItem(
                selected = true,
                onClick = item.action,
                colors = NavigationBarItemColors(
                    selectedIconColor = Color(0xFF53B175),
                    unselectedIconColor = Color(0xFF181725),
                    selectedTextColor = Color.Black,
                    selectedIndicatorColor = Color.White,
                    unselectedTextColor = Color.Black,
                    disabledIconColor = Color.Gray,
                    disabledTextColor = Color.Black
                ),
                icon = {
                    Image(
                        painter = painterResource(item.image),
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}