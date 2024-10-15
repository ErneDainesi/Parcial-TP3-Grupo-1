package com.example.parcial_tp3_grupo_1.data

import androidx.compose.ui.graphics.Color
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.screens.category.Categories
import com.example.parcial_tp3_grupo_1.model.ExploreItem
import com.example.parcial_tp3_grupo_1.model.Product
import com.example.parcial_tp3_grupo_1.model.Rating

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
    ),     ExploreItem(
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

//val id: Int,
//val title: String,
//val price: Double,
//val description: String,
//val category: String,
////validar image
//val image: String,
//val rating: Rating

val productos = listOf(
    Product(1, "Diet Coke", 1.99, "355ml, Price", Categories.BEVERAGES, R.drawable.dietcoke, Rating(4.5, 100)),
    Product(1, "Egg Chicken White", 1.49, "355ml, Price", Categories.DAIRY_AND_EGGS, R.drawable.eggchickenwhite, Rating(3.5, 100)),
    Product(1, "Egg eggnoodle", 1.49, "355ml, Price", Categories.DAIRY_AND_EGGS, R.drawable.eggnoodle, Rating(3.5, 100)),
    Product(1, "Egg eggchickenred", 1.49, "355ml, Price", Categories.DAIRY_AND_EGGS, R.drawable.eggchickenred, Rating(3.5, 100)),
    Product(1, "Egg eggpasta", 1.49, "355ml, Price", Categories.DAIRY_AND_EGGS, R.drawable.eggpasta, Rating(3.5, 100)),
    Product(1, "Sprite", 1.49, "355ml, Price", Categories.BEVERAGES, R.drawable.sprite, Rating(3.5, 100)),
    Product(1, "Pepsi", 1.49, "355ml, Price", Categories.BEVERAGES, R.drawable.pepsican, Rating(3.5, 100)),
    Product(1, "Sprite", 1.49, "355ml, sprite 2", Categories.BEVERAGES, R.drawable.sprite, Rating(3.5, 100)),
    Product(1, "Egg Chicken White", 1.49, "355ml, 2", Categories.DAIRY_AND_EGGS, R.drawable.eggchickenwhite, Rating(3.5, 100)),
    )