package com.physicswallah.rickandmorty.utils.navigation

sealed class RouteName(val route: String) {
    object Splash : RouteName("SplashScreen")
    object HomeScreen : RouteName("HomeScreen")
    object DetailScreen : RouteName("DetailScreen/{id}"){
        fun createRoute(id: Int) = "DetailScreen/$id"
    }
}