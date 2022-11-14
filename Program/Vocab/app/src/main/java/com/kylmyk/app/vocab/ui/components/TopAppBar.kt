package com.kylmyk.app.vocab.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.kylmyk.app.vocab.R
import com.kylmyk.app.vocab.ui.theme.VocabTheme

@Composable
fun MainPageTopAppBar(
    onClick: () -> Unit = {}
){
    CenterAlignedTopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
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

@Preview
@Composable
fun prevTopAppBar(){
    VocabTheme {
        MainPageTopAppBar()
    }
}