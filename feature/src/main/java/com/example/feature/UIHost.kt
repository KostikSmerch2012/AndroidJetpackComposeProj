package com.example.feature

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.feature.home.MainScreen
import com.example.feature.screens.recipe_screen.RecipeScreen
import com.example.feature.navigation.AppDestination
import com.example.feature.navigation.DestinationNavBar

@Composable
fun UIHost() {
    val navController = rememberNavController()
    val startDestination = DestinationNavBar.HOME
    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    Scaffold(
        modifier = Modifier.imePadding(),
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets, containerColor = Color(0xFFFFFCF7)) {
                DestinationNavBar.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.appDestination.route)
                            selectedDestination = index
                        },
                        icon = {
                            Log.i("DRAW ICON", destination.icon.toString() + " " + destination.label.toString())
                            Icon(
                                painterResource(destination.icon),
                                contentDescription = null
                            )
                        },
                        label = { Text(destination.label) }
                    )

                }
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .background(colorResource(R.color.creamy))
            .fillMaxSize()
            .consumeWindowInsets(paddingValues)
        ) {
            NavHost(
                navController,
                startDestination = startDestination.appDestination.route
            ) {
                AppDestination.entries.forEach { destination ->

                        when (destination) {
                            AppDestination.HOME -> composable(destination.route) {
                                Box(Modifier.padding(paddingValues)) {
                                    MainScreen(navController)
                                }
                            }

                            AppDestination.DETAIL_CARD -> composable(
                                destination.route,
                                arguments = listOf(
                                    navArgument("id") {
                                        type = NavType.StringType
                                        defaultValue = "null"
                                    }
                                )
                            ) { backStackEntry ->
                                Box(Modifier.padding(paddingValues)) {
                                    val id = backStackEntry.arguments?.getString("id")
                                    if (id != null) {
                                        RecipeScreen(id)
                                    } else {
                                        Box(
                                            Modifier.fillMaxSize(),
                                            Alignment.Center
                                        ) { Text("нет айди") }
                                    }
                                }
                            }

                            //todo остальные экраны
                            else -> composable(destination.route) {Box(Modifier.padding(paddingValues)) {
                                //...
                            }}
                        }

                }


            }

        }
    }
}