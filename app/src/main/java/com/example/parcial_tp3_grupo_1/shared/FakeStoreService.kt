package com.example.parcial_tp3_grupo_1.shared

import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FakeStoreService (
    private val fakestore: FakeStoreHelper
) {
    suspend fun getUsers(): List<User>? = withContext(Dispatchers.IO) {
        fakestore.getUsers()
    }

    suspend fun getProducts(): List<Product>? = withContext(Dispatchers.IO) {
        fakestore.getProducts()
    }

    suspend fun getProductById(id: Int): Product? = withContext(Dispatchers.IO) {
        fakestore.getProductById(id)
    }

    suspend fun getCategories(): List<String>? = withContext(Dispatchers.IO) {
        fakestore.getCategories()
    }

    suspend fun getProductsByCategory(category: String): List<Product>? = withContext(Dispatchers.IO) {
        fakestore.getProductsByCategory(category)
    }

    suspend fun getCartByUser(id: Int): Cart? = withContext(Dispatchers.IO) {
        fakestore.getCartByUser(id)
    }
}