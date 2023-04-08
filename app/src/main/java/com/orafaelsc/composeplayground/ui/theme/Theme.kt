package com.orafaelsc.composeplayground.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun ComposePlaygroundTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val extendedColors = if (darkTheme) darkExtendedColors else lightExtendedColors

    CompositionLocalProvider(values = arrayOf(localExtendedColors provides extendedColors)) {
        MaterialTheme(
            colors = if (darkTheme) darkColors else lightColors,
            typography = AppDefaultTypography,
            shapes = Shapes,
            content = content
        )
    }
}

object ComposePlaygroundTheme {

    val typographyCustom: AppCustomTypography
        @Composable
        get() = AppCustomTypography

    val colorsCustom: ExtendedColors
    @Composable
    get() = localExtendedColors.current

}