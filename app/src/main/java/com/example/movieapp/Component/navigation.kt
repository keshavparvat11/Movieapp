package com.example.movieapp.Component

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movieapp.screens.Detail
import com.example.movieapp.screens.MainContent


@Composable
fun MyNavigation() {
    var navcontrolar = rememberNavController()
    NavHost(navController = navcontrolar, startDestination = "home") {
        composable(route = "home") {
            MainContent(navcontrolar)
        }
        composable(route = "detail/{movie}") {
            var name  =  it.arguments?.getString("movie") ?: "No Move"
            Detail(name,navcontrolar)
        }
    }
}