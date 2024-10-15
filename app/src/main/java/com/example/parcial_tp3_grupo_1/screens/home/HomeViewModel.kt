package com.example.parcial_tp3_grupo_1.screens.home

import androidx.lifecycle.ViewModel
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val faketoreServive: FakeStoreService
): ViewModel() {
    suspend fun getExclusiveOffers(): List<Product>? {
        return withContext(Dispatchers.IO) {
            faketoreServive.getProductsByCategory("electronics")
        }
    }

    suspend fun getBestSelling(): List<Product>? {
        return withContext(Dispatchers.IO) {
            faketoreServive.getProductsByCategory("jewelery")
        }
    }
}