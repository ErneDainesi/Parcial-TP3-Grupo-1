package com.example.parcial_tp3_grupo_1.data

data class BottomNavItem(
    val title: String,
    val image: Int,
    val selectedImage: Int,
    val action: () -> Unit,
)
