package com.orafaelsc.composeplayground.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun AppCircularProgressBarIndicator(
    modifier: Modifier,
    @StringRes progressTextId: Int?,
    progressTextStyle: TextStyle = LocalTextStyle.current
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.padding(top = 12.dp, bottom = 6.dp))
        progressTextId?.run {
            Text(text = stringResource(id = this), modifier = modifier, style = progressTextStyle)
        }
    }
}

@Preview
@Composable
private fun LightCircularProgressIndicator(){
    ComposePlaygroundTheme(useDarkTheme = false) {
        AppCircularProgressBarIndicator(modifier = Modifier, progressTextId = R.string.progress)
    }
}
@Preview
@Composable
private fun DarkCircularProgressIndicator(){
    ComposePlaygroundTheme(useDarkTheme = true) {
        AppCircularProgressBarIndicator(modifier = Modifier, progressTextId = R.string.progress)
    }
}