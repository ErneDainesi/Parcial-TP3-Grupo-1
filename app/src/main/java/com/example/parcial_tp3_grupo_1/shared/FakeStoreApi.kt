package com.example.parcial_tp3_grupo_1.shared

import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface FakeStoreApi {
    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("products")
    suspend fun getProducts(): Response<List<Product>>

    @GET("products/{id}")
    suspend fun getProductById(
        @Path("id") id: Int
    ): Response<Product>

    @GET("products/categories")
    suspend fun getCategories(): Response<List<String>>

    @GET("products/category/{category}")
    suspend fun getProductsByCategory(
        @Path("category") category: String
    ): Response<List<Product>>

    @GET("carts/{id}")
    suspend fun getCartByUser(
        @Path("id") id: Int
    ): Response<Cart>

}