package com.kylmyk.app.vocab.ui.addScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kylmyk.app.vocab.ui.components.MainPageTopAppBar
import com.kylmyk.app.vocab.ui.components.TopLevelScaffold
import com.kylmyk.app.vocab.ui.theme.VocabTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AddScreen(navController: NavHostController){
    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            Text(text = "AddScreen",
                modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview
@Composable
fun PreviewGameMenuScreen(){
    VocabTheme {
        val navController = rememberNavController()
        AddScreen(navController)
    }
}