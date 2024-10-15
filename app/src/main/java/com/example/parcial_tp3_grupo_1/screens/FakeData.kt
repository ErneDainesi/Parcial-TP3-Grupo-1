package com.example.parcial_tp3_grupo_1.data

import androidx.compose.ui.graphics.Color
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.screens.category.Categories
import com.example.parcial_tp3_grupo_1.screens.explore.ExploreItem

val exploreItems = listOf(
    ExploreItem(
        "Fresh Fruits & Vegetables",
        R.drawable.explore_fresh_fruits_and_vegetables,
        Color(83, 177, 117, 26),
        Categories.FRUITS_AND_VEGETABLES
    ),
    ExploreItem(
        "Cooking Oil & Ghee",
        R.drawable.explore_cooking_oil_and_ghee,
        Color(248, 164, 76, 26),
        Categories.OIL_AND_GHEE
    ),
    ExploreItem(
        "Meat & Fish",
        R.drawable.explore_meat_and_fish,
        Color(247, 165, 147, 26),
        Categories.MEAT_AND_FISH
    ),
    ExploreItem(
        "Bakery & Snacks",
        R.drawable.explore_bakery_and_snacks,
        Color(211, 176, 224, 26),
        Categories.BAKERY_AND_SNACKS
    ),
    ExploreItem(
        "Dairy & Eggs",
        R.drawable.explore_dairy_and_eggs,
        Color(253, 229, 152, 26),
        Categories.DAIRY_AND_EGGS
    ),
    ExploreItem(
        "Beverages",
        R.drawable.explore_beverages,
        Color(183, 223, 245, 26),
        Categories.BEVERAGES
    )
)

data class Producto(
    val id: Int,
    val title: String,
    val price: Double,
    val description: String,
    val category: Categories,
    //validar image
    val image: Int,
    //val rating: Rating
)

val productos = listOf(
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),
    Producto(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke),


    )