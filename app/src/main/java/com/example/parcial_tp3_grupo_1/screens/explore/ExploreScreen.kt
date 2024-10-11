@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.parcial_tp3_grupo_1.screens.explore

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.parcial_tp3_grupo_1.R
import com.example.parcial_tp3_grupo_1.data.BottomNavItem
import com.example.parcial_tp3_grupo_1.data.ExploreItem
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions



val exploreItem = listOf(
    ExploreItem( "Fresh Fruits & Vegetables", R.drawable.explore_frashFruitsAndVegetable ),
    ExploreItem( "Cooking Oil & Ghee", R.drawable.explore_Oil_and_ghee ),
    ExploreItem( "Meat & Fish", R.drawable.explore_meatAndFish ),
    ExploreItem( "Bakery & Snacks", R.drawable.explore_bakeryAndSnacks ),
    ExploreItem( "Dairy & Eggs", R.drawable.explore_dairyAndEggs ),
    ExploreItem( "Beverages", R.drawable.explore_beverages ),
)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ExploreScreen(navigationActions: MainNavActions) {

    var query by remember { mutableStateOf("") }
    var active by remember { mutableStateOf(false) }

    Scaffold {
        SearchBar(
            modifier = Modifier.fillMaxWidth(),
            query = query ,
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
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon" )
            },
            trailingIcon = {
                if (active) {
                    Icon(
                        modifier = Modifier.clickable {
                            if (query.isNotEmpty()){
                                query = ""
                            } else {
                                active = false
                            }
                        },
                        imageVector = Icons.Default.Close,
                        contentDescription = "CLose Icon"
                    )
                } else {
                    Icon(
                        modifier = Modifier.clickable {
                            if (query.isNotEmpty()){
                                query = ""
                            } else {
                                active = false
                            }
                        },

                        imageVector = Icons.Default.MoreVert,
                        contentDescription = "CLose Icon"
                    )
                }

            }
        ) {

        }

    }

}