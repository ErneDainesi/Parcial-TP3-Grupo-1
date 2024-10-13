package com.example.parcial_tp3_grupo_1.model

data class User(
    val address: Address,
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val name: Name,
    val phone: String
)
