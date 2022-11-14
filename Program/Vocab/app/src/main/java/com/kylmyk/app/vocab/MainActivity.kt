package com.kylmyk.app.vocab

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.kylmyk.app.vocab.ui.components.MainPageTopAppBar
import com.kylmyk.app.vocab.ui.navigation.Screen
import com.kylmyk.app.vocab.ui.theme.VocabTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.kylmyk.app.vocab.ui.addScreen.AddScreen
import com.kylmyk.app.vocab.ui.game.gameMenuScreen.GameMenuScreen
import com.kylmyk.app.vocab.ui.homeScreen.HomeScreen
import com.kylmyk.app.vocab.ui.listScreen.ListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VocabTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BuildNavigationGraph()
                }
            }
        }
    }
}

@Composable
private fun BuildNavigationGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route){HomeScreen(navController) }
        composable(Screen.Game.route){GameMenuScreen(navController)}
        composable(Screen.Add.route){AddScreen(navController)}
        composable(Screen.List.route){ListScreen(navController)}
    }
}