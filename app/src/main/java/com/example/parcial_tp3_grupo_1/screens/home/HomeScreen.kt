package com.example.parcial_tp3_grupo_1.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.MainActivityViewModel
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.ui.components.ProductCard

@Composable
fun HomeScreen(
    navActions: MainNavActions,
    bestSelling: List<Product>,
    exclusiveOffers: List<Product>
) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp, start = 15.dp, end = 15.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Dhaka, Banassre",
                color = Color(0xFF4C4F4D),
                style = TextStyle(
                    fontWeight = FontWeight(600),
                    fontSize = 18.sp
                )
            )
            Box(
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.home_banner),
                    contentDescription = "Home Banner",
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                )
            }
        }
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Exclusive Offer",
                    color = Color(0xFF181725),
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 24.sp
                    )
                )
                TextButton(onClick = {}) {
                    Text(text = "See all", color = Color(0xFF53B175))
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(exclusiveOffers) {
                    ProductCard(
                        product = it,
                        navigationActions = navActions,
                        mainActivityViewModel = MainActivityViewModel()
                        //REVISAR @NICO
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Best Selling",
                    color = Color(0xFF181725),
                    style = TextStyle(
                        fontWeight = FontWeight(600),
                        fontSize = 24.sp
                    )
                )
                TextButton(onClick = {}) {
                    Text(text = "See all", color = Color(0xFF53B175))
                }
            }
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(bestSelling) {
                    ProductCard(
                        product = it,
                        navigationActions = navActions,
                        mainActivityViewModel = MainActivityViewModel()
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                }
            }
        }
    }
}