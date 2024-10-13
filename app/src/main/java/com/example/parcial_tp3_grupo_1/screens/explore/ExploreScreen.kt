@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parcial_tp3_grupo_1.screens.explore

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.data.ExploreItem
import com.example.parcial_tp3_grupo_1.data.exploreItems
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions


//@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExploreScreen(navigationActions: MainNavActions) {

    val categories: List<ExploreItem> = exploreItems

    //var filteredCategories

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Column {
        SearchBar(
            shape = RoundedCornerShape(16.dp),
            colors = SearchBarDefaults.colors(Color(242, 243, 242)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp, end = 15.dp),
            query = query,
            onQueryChange = {
                query = it
            },
            onSearch = {
                active = false
            },
            active = active,
            onActiveChange = {
                active = it
            },
            placeholder = {
                Text(text = "Search")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (query.isNotEmpty()) {
                                query = ""
                            } else {
                                active = false
                            }
                        }, imageVector = Icons.Default.Close, contentDescription = "CLose Icon"
                    )
                } else {
                    Image(
                        painterResource(id = R.drawable.tune_icon),
                        contentDescription = "Tune Filter Icon",
                        modifier = Modifier
                            .clickable {}
                            .size(16.dp, 17.dp),
                    )
                }
            }) { /*      TODO       */ }

        ExploreGrid(exploreItems, navigationActions)
    }
}

//@Preview
@Composable
fun ExploreGrid(
    exploreItems: List<ExploreItem> = listOf(
        ExploreItem(
            "Fresh Fruits & Vegetables",
            R.drawable.explore_fresh_fruits_and_vegetables,
            Color(83, 177, 117, 26)
        ),
        ExploreItem(
            "Cooking Oil & Ghee", R.drawable.explore_cooking_oil_and_ghee, Color(248, 164, 76, 26)
        ),
        ExploreItem("Meat & Fish", R.drawable.explore_meat_and_fish, Color(247, 165, 147, 26)),
        ExploreItem(
            "Bakery & Snacks", R.drawable.explore_bakery_and_snacks, Color(211, 176, 224, 26)
        ),
        ExploreItem("Dairy & Eggs", R.drawable.explore_dairy_and_eggs, Color(253, 229, 152, 26)),
        ExploreItem("Beverages", R.drawable.explore_beverages, Color(183, 223, 245, 26)),
    ),
    navigationActions: MainNavActions
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        exploreItems.chunked(2).forEach { rowItems ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,

                modifier = Modifier
                    .padding(top = 8.dp, bottom = 8.dp)
                    .fillMaxWidth()
            ) {
                rowItems.forEach { item ->
                    ExploreCard(item, navigationActions)
                }
            }
        }
    }
}

@Preview
@Composable
fun ExploreCard(
    item: ExploreItem = ExploreItem(
        "Fresh Fruits & Vegetable",
        R.drawable.explore_fresh_fruits_and_vegetables,
        Color(83, 177, 177, 70)
    ),
    navigationActions: MainNavActions
) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .border(
                width = 1.dp, color = item.backgroundColor, shape = RoundedCornerShape(16.dp)
            )
            .background(
                color = item.backgroundColor, shape = RoundedCornerShape(16.dp)
            )
            .padding(8.dp)
            .size(130.dp, 160.dp)
            .clickable {
                navigationActions.navigateToCategory()
            }
    ) {
        Image(
            painter = painterResource(item.image),
            contentDescription = item.title,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp)),
            alignment = Alignment.CenterStart
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            textAlign = TextAlign.Center, text = item.title, fontSize = 16.sp
        )
    }


}

