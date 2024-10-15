package com.example.parcial_tp3_grupo_1.screens.product

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.ui.components.BasicButton
import com.example.parcial_tp3_grupo_1.ui.components.QuantityButtons


@Composable
fun ProductDetailScreen(
    product: Product, navigationActions: MainNavActions
) {

    var isFavorite by remember {
        mutableStateOf(false)
    }

    var quantityCounter by rememberSaveable {
        mutableStateOf(1)
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {

            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier
//                    .clip(RoundedCornerShape(8.dp))
                    .height(200.dp)
                    .fillMaxWidth(),
                onError = { error -> Log.w("image error", "${error.result}") }
            )

            Spacer(modifier = Modifier.height(16.dp))
            Column(
                modifier = Modifier.padding(16.dp),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = product.title,
                            style = MaterialTheme.typography.headlineLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Text(text = product.category)
                        Icon(
                            imageVector = if (!isFavorite) Icons.Default.FavoriteBorder else Icons.Default.Favorite,
                            contentDescription = "Favorite",
                            tint = Color.Gray,
                            modifier = Modifier
                                .clickable { isFavorite = !isFavorite }
                                .align(Alignment.End)
                        )
                    }


                }
                Spacer(modifier = Modifier.padding(vertical = 16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    QuantityButtons()
                    Text(
                        text = "$${product.price}",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.Bold
                    )
                }
                Divider(
                    color = Color.LightGray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                AccordionComponent(title = "Product Detail", body = product.description)
                AccordionComponent(title = "Nutrition", body = "Nutrition information")
                AccordionComponent(title = "Review", body = "", rating = product.rating)

                Row(verticalAlignment = Alignment.Bottom) {
                    BasicButton(
                        text = "Add to Basket",
                        onClick = { /*TODO*/ },)
                }
            }
        }
    }
}

@Composable
fun AccordionComponent(
    title: String,
    body: String,
    rating: Rating? = null
) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded }
                .padding(vertical = 8.dp)
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            if (rating != null) {
                ProcessRating(rating.rate)
            }
            Icon(
                imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = if (isExpanded) "Collapse" else "Expand",
                tint = Color.Black,
                modifier = Modifier.size(25.dp)
            )
        }



        AnimatedVisibility(
            visible = isExpanded,
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(text = body)
            }
        }
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

    }
}

@Composable
fun ProcessRating(rating: Double) {
    if (rating in 4.5..5.0) {
        StarImage(drawable = R.drawable.fivestars, contentDescription = "5 stars")
    } else if (rating in 3.5..4.49) {
        StarImage(drawable = R.drawable.fourstars, contentDescription = "4 stars")
    } else if (rating in 2.5..3.49) {
        StarImage(drawable = R.drawable.threestars, contentDescription = "3 stars")
    } else if (rating in 1.5..2.49) {
        StarImage(drawable = R.drawable.twostars, contentDescription = "2 stars")
    } else {
        StarImage(drawable = R.drawable.onestar, contentDescription = "1 star")
    }
}

@Composable
fun StarImage(drawable: Int, contentDescription: String) {
    Image(
        painter = painterResource(id = drawable),
        contentDescription = contentDescription,
        modifier = Modifier
            .width(80.dp)
            .height(20.dp)
    )
}
