package com.kylmyk.app.vocab.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.kylmyk.app.vocab.R
import com.kylmyk.app.vocab.ui.navigation.Screen
import com.kylmyk.app.vocab.ui.navigation.screens
import com.kylmyk.app.vocab.ui.theme.VocabTheme

data class IconGroup(
    val filledIcon: ImageVector,
    val outlineIcon: ImageVector,
    val label: String
)

@Composable
fun MainPageNavigationBar(
    navController: NavController
) {
    //Add Icons to a List to add to the Bottom Bar
    val icons = mapOf(
        Screen.Game to IconGroup(
            filledIcon = Icons.Filled.Gamepad,
            outlineIcon = Icons.Outlined.Gamepad,
            label = stringResource(id = R.string.game)
        ),
        Screen.Add to IconGroup(
            filledIcon = Icons.Filled.Add,
            outlineIcon = Icons.Outlined.Add,
            label = stringResource(id = R.string.add)
        ),
        Screen.List to IconGroup(
            filledIcon = Icons.Filled.List,
            outlineIcon = Icons.Outlined.List,
            label = stringResource(id = R.string.list)
        )
    )


    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination


        // Adding the Icons from the list
        screens.forEach { screen ->
            val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            val labelText = icons[screen]!!.label

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = (
                                if (isSelected)
                                    icons[screen]!!.filledIcon
                                else
                                    icons[screen]!!.outlineIcon),
                        contentDescription = labelText
                    )
                },
                label = { Text(labelText) },
                selected = isSelected,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                }
            )
        }
    }
}


@Preview
@Composable
fun PreviewMainPageNavigationBar() {
    VocabTheme() {
        val navController = rememberNavController()
        MainPageNavigationBar(navController)
    }
}