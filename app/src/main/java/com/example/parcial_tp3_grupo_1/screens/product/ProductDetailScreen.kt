package com.example.parcial_tp3_grupo_1.screens.product

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.helpers.FakeStoreHelper
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.shared.FakeStoreService
import com.example.parcial_tp3_grupo_1.ui.components.BasicButton
import org.jetbrains.annotations.Async

@Composable
fun ProductDetailScreen(
    productId: Int = 1,
//    navigationActions: MainNavActions,
    viewModel: ProductDetailViewModel = ProductDetailViewModel(FakeStoreService(FakeStoreHelper()))
) {

    val product by viewModel.product
    val isLoading by viewModel.isLoading
    val errorMsg by viewModel.errorMsg

    LaunchedEffect(Unit) {
        viewModel.getProdById(productId)
    }

    when {
        isLoading -> {
            CircularProgressIndicator()
        }

        errorMsg != null -> {
            Text(text = errorMsg!!)
        }

        product != null -> {
            Text(text = "asd")
            ProductDetailView()
        }

        else -> {
            Text(text = "No se encontró el producto")
        }


    }


}

@Preview(showBackground = true)
@Composable
fun ProductDetailView(
    product: Product = Product(
        id = 1,
        title = "Banana",
        description = "Banana description",
        price = 15.5,
        category = "Fruit",
        image = R.drawable.banana.toString(),
        rating = Rating(4.5, 100)
    )
) {
    Column(modifier = Modifier.fillMaxSize()) {
//        No renderiza la imagen web
//        AsyncImage(
//            model = product.image,
//            contentDescription = product.title,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(200.dp),
//        )
        Image(
            painter = painterResource(id = R.drawable.banana),
            contentDescription = product.image,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
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
                }

                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = "Favorite",
                    tint = Color.Gray
                )

            }
            Spacer(modifier = Modifier.padding(vertical = 16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                //boton - + y cantidad
                Column {
                    Row {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Decrease quantity",
                                tint = colorResource(
                                    id = R.color.border_item_card_color
                                )
                            )
                        }
                        Box(
                            modifier = Modifier
                                .size(45.dp)
                                .clip(RoundedCornerShape(16.dp))
                                .background(Color.White)
                                .border(2.dp, Color(0xFFE2E2E2), RoundedCornerShape(16.dp))
                        ) {
                            Text(
                                text = "1",
                                fontSize = 20.sp,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }

                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowUp,
                                contentDescription = "Increase quantity",
                                tint = colorResource(
                                    id = R.color.principal_button_color
                                )
                            )
                        }
                    }
                }
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
                BasicButton(text = "Add to Basket", onClick = { /*Redirect to Cart*/ })
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
    var isExpanded by remember { mutableStateOf(false) } // Estado para saber si está expandido o no

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { isExpanded = !isExpanded } // Cambia el estado al hacer clic
                .padding(vertical = 8.dp)
                .height(40.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {// Título del acordeón
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
        // Línea divisoria
        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Contenido que se muestra/oculta según el estado de expansión
        AnimatedVisibility(
            visible = isExpanded,
        ) {
            Column(modifier = Modifier.padding(vertical = 8.dp)) {
                Text(text = body)
            }
        }

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
            .width(100.dp)
            .height(40.dp)
    )
}
