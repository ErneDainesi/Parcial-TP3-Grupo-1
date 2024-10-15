package com.example.parcial_tp3_grupo_1.screens.favorite

import androidx.lifecycle.ViewModel
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavoriteViewModel (
    private val fakeStoreService: FakeStoreService
) : ViewModel() {

    suspend fun getFavorites(): List<Product>?{
        return withContext(Dispatchers.IO){
            fakeStoreService.getProductsByCategory("men's clothing")
        }
    }

}