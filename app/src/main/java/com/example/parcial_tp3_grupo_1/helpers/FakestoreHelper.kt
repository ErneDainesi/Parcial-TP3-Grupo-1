package com.example.parcial_tp3_grupo_1.helpers

import com.example.parcial_tp3_grupo_1.model.User
import com.example.parcial_tp3_grupo_1.shared.FakestoreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakestoreHelper {
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
    private val api = retrofit.create(FakestoreApi::class.java)

    suspend fun getUsers(): List<User>? {
        val response = api.getUsers()
        return if (response.isSuccessful) {
            val result = response.body()?.map {
                User(
                    address = it.address,
                    id = it.id,
                    email = it.email,
                    username = it.username,
                    password = it.password,
                    name = it.name,
                    phone = it.phone
                )
            }
            result
        } else {
            emptyList()
        }
    }
}
