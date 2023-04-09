package com.orafaelsc.composeplayground.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.orafaelsc.composeplayground.R

val lightColors: Colors
    @Composable
    get() = Colors(
        //primary
        primary = colorResource(id = R.color.light_primary),
        primaryVariant = colorResource(id = R.color.light_primary_light),
        onPrimary = colorResource(id = R.color.light_on_primary),
        secondary = colorResource(id = R.color.light_secondary),
        secondaryVariant = colorResource(id = R.color.light_secondary_light),
        onSecondary = colorResource(id = R.color.light_on_secondary),
        background = colorResource(id = R.color.light_background),
        onBackground = colorResource(id = R.color.light_primary_text),
        surface = colorResource(id = R.color.light_background),
        error = colorResource(id = R.color.light_error),
        onError = colorResource(id = R.color.light_on_error),
        onSurface = colorResource(id = R.color.light_surface),
        isLight = true
    )

val darkColors: Colors
    @Composable
    get() = Colors(
        primary = colorResource(id = R.color.dark_primary),
        primaryVariant = colorResource(id = R.color.dark_primary_light),
        onPrimary = colorResource(id = R.color.dark_on_primary),
        secondary = colorResource(id = R.color.dark_secondary),
        secondaryVariant = colorResource(id = R.color.dark_secondary_light),
        onSecondary = colorResource(id = R.color.dark_on_secondary),
        background = colorResource(id = R.color.dark_background),
        onBackground = colorResource(id = R.color.dark_primary_text),
        surface = colorResource(id = R.color.dark_background),
        error = colorResource(id = R.color.dark_error),
        onError = colorResource(id = R.color.dark_on_error),
        onSurface = colorResource(id = R.color.dark_surface),
        isLight = false
    )

@Immutable
data class ExtendedColors(
    val companyAlert: Color
)

val localExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        companyAlert = Color.Unspecified
    )
}

val lightExtendedColors: ExtendedColors
    @Composable
    get() = ExtendedColors(
        companyAlert = colorResource(id = R.color.light_company_alert)
    )
val darkExtendedColors: ExtendedColors
    @Composable
    get() = ExtendedColors(
        companyAlert = colorResource(id = R.color.dark_company_alert)
    )


@Preview
@Composable
fun LightColorsPreview() {
    ComposePlaygroundTheme(darkTheme = false) {
        ColorList()
    }
}

@Preview
@Composable
fun DarkColorsPreview() {
    ComposePlaygroundTheme(darkTheme = true) {
        ColorList()
    }
}

@Composable
fun ColorList() {
    Column(
        modifier = Modifier
            .verticalScroll(
                state = rememberScrollState()
            )
            .fillMaxHeight()
    ) {
        mapOf(
            "primary" to MaterialTheme.colors.primary,
            "primaryVariant" to MaterialTheme.colors.primaryVariant,
            "onPrimary" to MaterialTheme.colors.onPrimary,
            "secondary" to MaterialTheme.colors.secondary,
            "secondaryVariant" to MaterialTheme.colors.secondaryVariant,
            "onSecondary" to MaterialTheme.colors.onSecondary,
            "background" to MaterialTheme.colors.background,
            "onBackground" to MaterialTheme.colors.onBackground,
            "surface" to MaterialTheme.colors.surface,
            "error " to MaterialTheme.colors.error,
            "onError" to MaterialTheme.colors.onError,
            "onSurface" to MaterialTheme.colors.onSurface,
        ).forEach { (text, color) ->
            Row {
                Text(text = text, modifier = Modifier
                    .weight(2f)
                    .background(color)
                    .height(60.dp)
                )
            }
        }
    }
}