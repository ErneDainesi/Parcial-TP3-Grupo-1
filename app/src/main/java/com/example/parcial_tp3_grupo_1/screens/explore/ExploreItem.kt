package com.example.parcial_tp3_grupo_1.screens.explore

import androidx.compose.ui.graphics.Color
import com.example.parcial_tp3_grupo_1.screens.category.Categories

data class ExploreItem(
    val title: String,
    val image: Int,
    val backgroundColor: Color,
    val category: Categories
)



