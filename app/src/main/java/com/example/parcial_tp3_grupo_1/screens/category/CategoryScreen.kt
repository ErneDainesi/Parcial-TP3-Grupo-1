package com.example.parcial_tp3_grupo_1.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.data.productos
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.screens.explore.ExploreCard
import com.example.parcial_tp3_grupo_1.ui.components.ProductCard


@Composable
fun CategoryScreen(navigationActions: MainNavActions, category: String) {

    val productCategory = productos.filter { it.category == category }

    LazyColumn {

        item {

            if (productCategory.isEmpty()) {
                Text(
                    text = "No products found",
                    modifier = Modifier.padding(16.dp)
                )
            } else {
                productCategory.chunked(2).forEach { rowItems ->
                    LazyRow(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly,

                        modifier = Modifier
                            .padding(top = 16.dp, bottom = 16.dp)
                            .fillMaxWidth()
                    ) {
                        item {
                            rowItems.forEach { item ->
                                ProductCard(item, { }, navigationActions)
                                Spacer(modifier = Modifier.width(20.dp))
                            }

                        }
                    }
                }
            }

        }


    }

}