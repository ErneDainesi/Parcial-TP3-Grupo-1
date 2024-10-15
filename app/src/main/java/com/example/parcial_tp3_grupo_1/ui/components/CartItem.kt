package com.example.parcial_tp3_grupo_1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.model.Product

@Composable
fun CartItem(
    product: Product
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Column {
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier.size(50.dp)
            )
        }

        Row(
            modifier = Modifier
                .height(75.dp)
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.width(150.dp)) {
                Text(
                    text = product.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    overflow = TextOverflow.Ellipsis,
                    softWrap = false
                )
                Text(
                    text = product.category,
                    fontSize = 10.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.fillMaxWidth()
                )
                QuantityButtons()
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                IconButton (onClick = {}) {
                    Image(
                        painter = painterResource(id = R.drawable.close_cart_item),
                        contentDescription = "Remove from cart",
                        modifier = Modifier.size(10.dp)
                    )
                }
                Text(
                    text = "$${product.price}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
            }
        }
    }
    HorizontalDivider(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
        thickness = 1.dp,
        color = Color.LightGray
    )
}
