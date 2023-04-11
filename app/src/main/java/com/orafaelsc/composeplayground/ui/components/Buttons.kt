package com.orafaelsc.composeplayground.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme


@Composable
fun AppButton(
    modifier: Modifier,
    onclick: () -> Unit,
    @StringRes stringId: Int
) {
    Button(modifier = modifier, onClick = onclick) {
        Text(text = stringResource(id = stringId))
    }
}

@Composable
fun AppButtonRow(
    modifier: Modifier,
    positiveAction: (() -> Unit)? = null,
    negativeAction: (() -> Unit)? = null,
    neutralAction: (() -> Unit)? = null,
    @StringRes positiveTextId: Int? = null,
    @StringRes negativeTextId: Int? = null,
    @StringRes neutralTextId: Int? = null,
) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        negativeAction?.let { clickAction ->
            negativeTextId?.let { textId ->
                AppButton(modifier, clickAction, textId)
            }
        } ?: Spacer(modifier = modifier)

        neutralAction?.let { clickAction ->
            neutralTextId?.let { textId ->
                AppButton(modifier, clickAction, textId)
            }
        } ?: Spacer(modifier = modifier)

        positiveAction?.let { clickAction ->
            positiveTextId?.let { textId ->
                AppButton(modifier, clickAction, textId)
            }
        } ?: Spacer(modifier = modifier)
    }
}

@Preview
@Composable
fun LightButtonPreview() {
    ComposePlaygroundTheme(useDarkTheme = false) {
        AppButton(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            {},
            R.string.template
        )
    }
}

@Preview
@Composable
fun DarkButtonPreview() {
    ComposePlaygroundTheme(useDarkTheme = true) {
        AppButton(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            {},
            R.string.template
        )
    }
}

@Preview
@Composable
fun RowLightPreview() {
    ComposePlaygroundTheme(useDarkTheme = false) {
        AppButtonRow(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            positiveAction = {},
            positiveTextId = R.string.template,
            neutralAction = {},
            neutralTextId = R.string.template,
            negativeAction = {},
            negativeTextId = R.string.template,
        )
    }
}

@Preview
@Composable
fun RowDarkPreview() {
    ComposePlaygroundTheme(useDarkTheme = true) {
        AppButtonRow(
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            positiveAction = {},
            positiveTextId = R.string.template,
            neutralAction = {},
            neutralTextId = R.string.template,
            negativeAction = {},
            negativeTextId = R.string.template,
        )
    }
}