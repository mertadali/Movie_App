package com.mertadali.movieappkotlin.presentation.main_Activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mertadali.movieappkotlin.presentation.Screen
import com.mertadali.movieappkotlin.presentation.movies.views.MovieScreen
import com.mertadali.movieappkotlin.presentation.theme.ui.MovieAppKotlinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MovieAppKotlinTheme {

                // recomposition

                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.MovieScreen.route ){
                        composable(route =Screen.MovieScreen.route){
                            MovieScreen(navController = navController)
                        }
                        composable(route =Screen.MovieDetailScreen.route){
                        }
                    }
                }
            }
        }
    }
}
