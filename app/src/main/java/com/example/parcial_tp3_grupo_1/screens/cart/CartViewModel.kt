package com.example.parcial_tp3_grupo_1.screens.cart

import androidx.lifecycle.ViewModel
import com.example.parcial_tp3_grupo_1.model.Cart
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CartViewModel(
    private val faketoreServive: FakeStoreService
): ViewModel() {
    suspend fun getCart(): Cart? {
        return withContext(Dispatchers.IO) {
            faketoreServive.getCartByUser(1)
        }
    }

    suspend fun getProductById(id: Int): Product? {
        return withContext(Dispatchers.IO) {
            faketoreServive.getProductById(id)
        }
    }
}
