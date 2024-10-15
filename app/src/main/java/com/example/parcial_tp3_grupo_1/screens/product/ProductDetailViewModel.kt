package com.example.parcial_tp3_grupo_1.screens.product

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailViewModel(
    private val fakeStoreService: FakeStoreService
) : ViewModel() {

    suspend fun getProd(productId: Int): Product? {
        return withContext(Dispatchers.IO){ fakeStoreService.getProductById(productId) }
    }
}