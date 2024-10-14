package com.example.parcial_tp3_grupo_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating
import com.example.parcial_tp3_grupo_1.navigation.AppDestinations
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.navigation.MainRouteNavGraph
import com.example.parcial_tp3_grupo_1.ui.components.AddedToCartFAB
import com.example.parcial_tp3_grupo_1.ui.components.BottomNavBar
import com.example.parcial_tp3_grupo_1.ui.components.ProductCard
import com.example.parcial_tp3_grupo_1.ui.theme.ParcialTP3Grupo1Theme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTP3Grupo1Theme {
                val navController = rememberNavController()

                val navigationActions = remember(navController) {
                    MainNavActions(navController)
                }

                //Se utilizan para mostrar el boton cuando un elemento es añadido al carrito de manera rapida
                var showFAB by remember { mutableStateOf(false) }
                LaunchedEffect(showFAB) {
                    if (showFAB) {
                        delay(3000L)
                        showFAB = false;
                    }
                }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    floatingActionButton = {
                        AddedToCartFAB(
                            showFAB,
                            navigationActions = navigationActions
                        )
                    },
                    bottomBar = {
                        val currentLocation =
                            navController.currentBackStackEntryAsState().value?.destination?.route
                        if (!navigationActions.shouldHideBottombar(currentLocation)) {
                            BottomNavBar(navigationActions = navigationActions)
                        }
                    }
                )
                { innerPadding ->
//                    Column(
//                        modifier = Modifier.padding(innerPadding),
//                        verticalArrangement = Arrangement.Center,
//                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        ProductCard(
//                            product = Product(
//                                id = 1,
//                                title = "Producto 1",
//                                description = "Descripcion del producto 1",
//                                price = 100.0,
//                                image = "https://picsum.photos/200/300",
//                                category = "Categoria 1",
//                                rating = Rating(4.5, 100),
//                            ),
//                            navigationActions = navigationActions,
//                            onAddToCartClick = {
//                                showFAB = true
//                            }
//                        )
//                    }

                    MainRouteNavGraph(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                        startDestination = AppDestinations.SIGNIN_ROUTE,
                        navigationActions = navigationActions
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParcialTP3Grupo1Theme {
        Greeting("Android")
    }
}