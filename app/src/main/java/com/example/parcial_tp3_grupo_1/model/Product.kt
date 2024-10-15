package com.example.parcial_tp3_grupo_1.model

data class Product(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: String,
    //validar image
    val image: Int,
    val rating: Rating
)
