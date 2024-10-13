package com.example.parcial_tp3_grupo_1.helpers

import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.User
import com.example.parcial_tp3_grupo_1.shared.FakeStoreApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FakeStoreHelper {
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()
    private val api = retrofit.create(FakeStoreApi::class.java)

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

    suspend fun getProducts(): List<Product>? {
        val response = api.getProducts()
        return if (response.isSuccessful){
            val result = response.body()?.map {
                Product(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    description = it.description,
                    category = it.category,
                    image = it.image,
                    rating = it.rating
                )
            }
            result
        } else {
            emptyList()
        }
    }

    suspend fun getProductById(id: Int): Product? {
        val response = api.getProductById(id)
        return if (response.isSuccessful) {
            val result = response.body()?.let {
                Product(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    description = it.description,
                    category = it.category,
                    image = it.image,
                    rating = it.rating
                )
            }
            result
        } else {
            null
        }
    }

    suspend fun getCategories(): List<String>? {
        val response = api.getCategories()
        return if (response.isSuccessful) {
            response.body()
        } else {
            emptyList()
        }
    }

    suspend fun getProductsByCategory(category: String): List<Product>? {
        val response = api.getProductsByCategory(category)
        return if (response.isSuccessful) {
            val result = response.body()?.map {
                Product(
                    id = it.id,
                    title = it.title,
                    price = it.price,
                    description = it.description,
                    category = it.category,
                    image = it.image,
                    rating = it.rating
                )
            }
            result
        } else {
            emptyList()
        }
    }

    suspend fun getCartByUser(id: Int): List<Cart>? {
        val response = api.getCartByUser(id)
        return if (response.isSuccessful) {
            val result = response.body()?.map {
                Cart(
                    id = it.id,
                    userId = it.userId,
                    date = it.date,
                    products = it.products
                )
            }
            result
        } else {
            emptyList()
        }
    }
}
