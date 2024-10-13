package com.example.parcial_tp3_grupo_1.shared

import com.example.parcial_tp3_grupo_1.helpers.FakestoreHelper
import com.example.parcial_tp3_grupo_1.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetServiceUsers (
    private val fakstore: FakestoreHelper
) {
    suspend fun execute(): List<User>? = withContext(Dispatchers.IO) {
        fakstore.getUsers()
    }
}