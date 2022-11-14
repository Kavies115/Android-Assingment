package com.kylmyk.app.vocab.ui.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen("home")
    object Add : Screen("add")
    object Game : Screen("game")
    object List : Screen("list")

}

val screens = listOf(
    Screen.Game,
    Screen.Add,
    Screen.List
)
