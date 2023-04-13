package com.orafaelsc.composeplayground.ui.view


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.ui.components.AppButton
import com.orafaelsc.composeplayground.ui.components.AppCircularProgressBarIndicator
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme
import com.orafaelsc.composeplayground.ui.viewmodel.ObserveStateViewModel


@Composable
fun LoadingView(viewModel: ObserveStateViewModel) {
    val isLoading by viewModel.loadingStateFlow().collectAsState()

    if (isLoading) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AppCircularProgressBarIndicator(
                modifier = Modifier,
                progressTextId = R.string.loading
            )
            AppButton(
                modifier = Modifier,
                onclick = { viewModel.setLoadingState(false) },
                stringId = R.string.stop_loading
            )
        }
    } else {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(id = R.string.loading_finished))
            AppButton(
                modifier = Modifier,
                onclick = { viewModel.setLoadingState(true) },
                stringId = R.string.start_loading
            )
        }
    }
}

@Preview
@Composable
private fun LoadingViewLightPreview() {
    ComposePlaygroundTheme(useDarkTheme = false) {
        LoadingView(ObserveStateViewModel().apply {
            setLoadingState(true)
        })
    }
}


@Preview
@Composable
private fun LoadingViewDarkPreview() {
    ComposePlaygroundTheme(useDarkTheme = true) {
        LoadingView(ObserveStateViewModel().apply {
            setLoadingState(true)
        })
    }
}

