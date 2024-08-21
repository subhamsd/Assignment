package com.physicswallah.rickandmorty.utils.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.physicswallah.rickandmorty.presentations.details.DetailScreen
import com.physicswallah.rickandmorty.presentations.home.HomeScreen
import com.physicswallah.rickandmorty.presentations.splash.SplashScreen


@Composable
fun NavigationRoute(navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(
            navController = navController,
            startDestination = RouteName.Splash.route,
        ) {
            composable(RouteName.Splash.route) {
                SplashScreen(navController)
            }
            composable(RouteName.HomeScreen.route) {
                HomeScreen(navController)
            }
            composable(RouteName.DetailScreen.route) {
                val arg = it.arguments?.getString("id")?.toIntOrNull() ?: 0
                DetailScreen(navController = navController, id = arg)
            }
        }
    }
}