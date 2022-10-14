package com.example.noteapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.noteapp.MainActivity

@Composable
fun Navigation(
    navController: NavHostController,
    activity: MainActivity
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    )
    {
        composable(
            route = Screen.CoinListScreen.route
        ) {}
    }

}