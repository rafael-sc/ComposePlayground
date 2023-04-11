package com.orafaelsc.composeplayground.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orafaelsc.composeplayground.R
import com.orafaelsc.composeplayground.ui.theme.ComposePlaygroundTheme

@Composable
fun AppIconImage(
    @DrawableRes iconLightId: Int,
    iconColor: Color = MaterialTheme.colors.primary,
    backgroundColor: Color = MaterialTheme.colors.background,
    onClick: () -> Unit = {},
    contentDescription: String? = null
) {
    Box(modifier = Modifier
        .padding(12.dp)
        .size(38.dp)
        .clip(CircleShape)
        .background(backgroundColor)
        .clickable { onClick() }) {
        Image(
            painter = painterResource(id = iconLightId),
            contentDescription = contentDescription,
            modifier = Modifier
                .padding(12.dp)
                .align(Alignment.Center)
                .clickable { onClick() },
            colorFilter = ColorFilter.tint(iconColor)
        )

    }
}

@Preview
@Composable
fun IconImageLightPreview() {
    ComposePlaygroundTheme(useDarkTheme = false) {
        AppIconImage(
            R.drawable.ic_airplane_mode,
        )
    }
}

@Preview
@Composable
fun IconImageDarkPreview() {
    ComposePlaygroundTheme(useDarkTheme = true) {
        AppIconImage(
            R.drawable.ic_airplane_mode,
        )
    }
}
