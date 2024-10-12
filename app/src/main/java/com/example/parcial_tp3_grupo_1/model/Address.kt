package com.example.parcial_tp3_grupo_1.model

data class Address(
    val geolocation: Geolocation,
    val city: String,
    val street: String,
    val number: Int,
    val zipcode: String
)
