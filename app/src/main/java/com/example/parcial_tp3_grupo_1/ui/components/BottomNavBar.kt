package com.example.parcial_tp3_grupo_1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.data.BottomNavItem
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions

@Composable
fun BottomNavBar(
    navigationActions: MainNavActions,
) {
    var selectedItem by remember { mutableIntStateOf(0) }
    val navItems = listOf(
        BottomNavItem("Shop", R.drawable.shopicon, R.drawable.shopicon_selected, navigationActions.navigateToShop),
        BottomNavItem("Explore", R.drawable.exploreicon, R.drawable.exploreicon_selected, navigationActions.navigateToExplore),
        BottomNavItem("Cart", R.drawable.carticon, R.drawable.carticon_selected, navigationActions.navigateToCart),
        BottomNavItem("Favorite", R.drawable.favoriteicon, R.drawable.favoriteicon_selected, navigationActions.navigateToFavorite),
        BottomNavItem("Account", R.drawable.accounticon, R.drawable.accounticon_selected, navigationActions.navigateToAccount),
    )

    NavigationBar (
        containerColor = Color.White,
        modifier = Modifier
            .clip(RoundedCornerShape(15.dp))
            .shadow(8.dp)
            .background(Color(0xFFE6EBF3).copy(alpha = 0.5f))
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