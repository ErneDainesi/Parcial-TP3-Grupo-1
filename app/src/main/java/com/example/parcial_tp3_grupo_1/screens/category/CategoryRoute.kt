package com.example.parcial_tp3_grupo_1.screens.category

import androidx.compose.runtime.Composable
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.screens.explore.ExploreScreen

@Composable
fun CategoryRoute(
    navigationActions: MainNavActions, category: String
) {
    CategoryScreen(navigationActions,  category)
}