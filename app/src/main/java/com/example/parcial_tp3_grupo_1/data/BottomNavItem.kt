package com.example.parcial_tp3_grupo_1.data

data class BottomNavItem(
    val title: String,
    val image: Int,
    val action: () -> Unit,
)
