package com.kylmyk.app.vocab.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.kylmyk.app.vocab.R
import com.kylmyk.app.vocab.ui.navigation.Screen
import com.kylmyk.app.vocab.ui.theme.VocabTheme

@Composable
fun MainPageTopAppBar(
    onClick: () -> Unit = {},
    navController: NavController
){
    CenterAlignedTopAppBar(
        title = {
            LogoButton(navController)
        },
        actions = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = Icons.Filled.Settings,
                    contentDescription =
                    stringResource(R.string.settings)
                )
            }
        }

    )
}


//Makes the Logo a Button that lets you go back to the home Screen
@Composable
fun LogoButton(
    navController: NavController
){
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.primary),
        onClick = {
            navController.navigate(Screen.Home.route) {
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        content = {
            Text(stringResource(id = R.string.app_name), fontSize = 40.sp)
        },
        modifier = Modifier.fillMaxWidth()

    )
}

@Preview
@Composable
fun prevTopAppBar(){
    VocabTheme {
        val navController = rememberNavController()
        MainPageTopAppBar(navController = navController)
    }
}

@Preview
@Composable
fun prevButton(){
    VocabTheme {
        val navController = rememberNavController()
        LogoButton(navController)
    }
}