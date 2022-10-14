package com.example.noteapp.ui

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_screen")
    object NotificationScreen : Screen("notification_screen")
    object WeatherScreen : Screen("weather_screen")
}