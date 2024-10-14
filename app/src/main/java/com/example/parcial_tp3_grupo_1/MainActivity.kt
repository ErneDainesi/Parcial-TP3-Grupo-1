package com.example.parcial_tp3_grupo_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcial_tp3_grupo_1.navigation.AppDestinations
import com.example.parcial_tp3_grupo_1.navigation.DynamicTopBar
import com.example.parcial_tp3_grupo_1.navigation.MainNavActions
import com.example.parcial_tp3_grupo_1.navigation.MainRouteNavGraph
import com.example.parcial_tp3_grupo_1.screens.Account.AccountScreen
import com.example.parcial_tp3_grupo_1.ui.components.BottomNavBar
import com.example.parcial_tp3_grupo_1.ui.theme.ParcialTP3Grupo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ParcialTP3Grupo1Theme {
                val navController = rememberNavController()

                val navigationActions = remember(navController) {
                    MainNavActions(navController)
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route
                        if (!navigationActions.shouldHideBottombar(currentLocation)) {
                            BottomNavBar(navigationActions = navigationActions)
                        }
                    },
                    topBar = {
                        val currentLocation = navController.currentBackStackEntryAsState().value?.destination?.route
                        DynamicTopBar(currentLocation)
                    }
                ) { innerPadding ->
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