package com.example.parcial_tp3_grupo_1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberImagePainter
import com.example.parcial_tp3_grupo_1.R

@Preview
@Composable
fun ViewProductCard() {
    ProductCard(
        name = "Organic Bananas",
        description = "7pcs, price per kg",
        price = 4.99,
        category = "ASD",
        quantity = 10,
    )
}

@Composable
fun ProductCard(
//    imageUrl: String = "https://picsum.photos/200/200",
    name: String = "",
    description: String = "",
    price: Double = 0.0,
    category: String = "",
    quantity: Int = 0,
) {


    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .wrapContentSize()
            .wrapContentHeight()
            .border(
                width = 1.dp,
                color = Color.Gray,
                shape = RoundedCornerShape(16.dp)
            ),

        onClick = { /*redireccionar a Detalle del Producto*/ }
    ) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
                .wrapContentHeight()
                .wrapContentWidth()
        ) {
            Image(
//                cambiar por imageUrl
                painter = painterResource(id = R.drawable.banana),
                contentDescription = name,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp)),
                alignment = Alignment.CenterStart,

                )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text(text = description, fontSize = 16.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "$$price",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(30.dp))
                IconButton(
                    onClick = { /*funcion para mostrar FAB de added to cart*/ },
                    modifier = Modifier.size(50.dp),
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to cart",
                        tint = Color.White,

                        modifier = Modifier
                            .background(
                                color = colorResource(id = R.color.add_to_cart_button),
                                shape = RoundedCornerShape(16.dp),
                            )
                            .padding(8.dp)
                            .size(24.dp)


                    )
                }
            }

        }

    }


}