package com.example.parcial_tp3_grupo_1.shared

import com.example.parcial_tp3_grupo_1.model.User
import retrofit2.Response
import retrofit2.http.GET

interface FakestoreApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>
}