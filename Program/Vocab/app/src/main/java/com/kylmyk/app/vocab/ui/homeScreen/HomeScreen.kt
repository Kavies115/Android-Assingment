package com.kylmyk.app.vocab.ui.homeScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.kylmyk.app.vocab.R
import com.kylmyk.app.vocab.ui.components.MainPageTopAppBar
import com.kylmyk.app.vocab.ui.components.TopLevelScaffold
import com.kylmyk.app.vocab.ui.theme.VocabTheme
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController){
    TopLevelScaffold(
        navController = navController
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            HomeScreenContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(){
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 12.dp, end = 12.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                TextInCard(stringResource(R.string.card1_Text1))
                TextInCard(stringResource(R.string.app_name), 40.sp)
                TextInCard(stringResource(R.string.card1_Text2))
            }
        }
        Row() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                TextInCard(stringResource(R.string.app_name))
                TextInCard(stringResource(R.string.app_name), 40.sp)
                TextInCard(stringResource(R.string.app_name))
            }
        }
        Row() {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, bottom = 8.dp)
            ) {
                TextInCard(stringResource(R.string.card1_Text1))
                TextInCard(stringResource(R.string.app_name), 40.sp)
                TextInCard(stringResource(R.string.card1_Text2))
            }
        }
    }
}

@Composable
fun TextInCard(
    text: String = "",
    fontSize: TextUnit = 20.sp
){
    Text((text),
        Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = fontSize
    )
}

@Preview
@Composable
fun PreviewHomeScreen(){
    VocabTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}