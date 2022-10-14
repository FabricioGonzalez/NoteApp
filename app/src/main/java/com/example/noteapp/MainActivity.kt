package com.example.noteapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.noteapp.ui.BottomNavItem
import com.example.noteapp.ui.BottomNavigationBar
import com.example.noteapp.ui.Navigation
import com.example.noteapp.ui.Screen
import com.example.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NoteAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()

                val navController = rememberNavController()
                // A surface container using the 'background' color from the theme
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    backgroundColor = MaterialTheme.colors.background,

                    ) {
                    Navigation(
                        navController = navController,
                        this
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            backgroundColor = MaterialTheme.colors.background,
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        BottomNavItem(
                            name = "cripto",
                            route = Screen.CoinListScreen.route,
                            icon = Icons.Default.Info
                        ),
                        BottomNavItem(
                            name = "notifications",
                            route = Screen.NotificationScreen.route,
                            icon = Icons.Default.Notifications
                        ),
                        BottomNavItem(
                            name = "weather",
                            route = Screen.WeatherScreen.route,
                            icon = Icons.Default.Refresh
                        )
                    ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }) {
            /*   Navigation(
                   navController = navController,
                   this
               )*/
            /*  Greeting("Android")*/
        }
    }
}