package com.orafaelsc.composeplayground.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import com.orafaelsc.composeplayground.R
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


val LightThemeColors: ColorScheme @Composable get() = lightColorScheme(
    primary = colorResource(id = R.color.light_primary),
    onPrimary = colorResource(id = R.color.light_onPrimary),
    primaryContainer = colorResource(id = R.color.light_primaryContainer),
    onPrimaryContainer = colorResource(id = R.color.light_onPrimaryContainer),
    secondary = colorResource(id = R.color.light_secondary),
    onSecondary = colorResource(id = R.color.light_onSecondary),
    secondaryContainer = colorResource(id = R.color.light_secondaryContainer),
    onSecondaryContainer = colorResource(id = R.color.light_onSecondaryContainer),
    tertiary = colorResource(id = R.color.light_tertiary),
    onTertiary = colorResource(id = R.color.light_onTertiary),
    tertiaryContainer = colorResource(id = R.color.light_tertiaryContainer),
    onTertiaryContainer = colorResource(id = R.color.light_onTertiaryContainer),
    error = colorResource(id = R.color.light_error),
    errorContainer = colorResource(id = R.color.light_errorContainer),
    onError = colorResource(id = R.color.light_onError),
    onErrorContainer = colorResource(id = R.color.light_onErrorContainer),
    background = colorResource(id = R.color.light_background),
    onBackground = colorResource(id = R.color.light_onBackground),
    surface = colorResource(id = R.color.light_surface),
    onSurface = colorResource(id = R.color.light_onSurface),
    surfaceVariant = colorResource(id = R.color.light_surfaceVariant),
    onSurfaceVariant = colorResource(id = R.color.light_onSurfaceVariant),
    outline = colorResource(id = R.color.light_outline),
    inverseOnSurface = colorResource(id = R.color.light_inverseOnSurface),
    inverseSurface = colorResource(id = R.color.light_inverseSurface),
    inversePrimary = colorResource(id = R.color.light_inversePrimary),
)

val DarkThemeColors: ColorScheme @Composable get() = darkColorScheme(
    primary = colorResource(id = R.color.dark_primary),
    onPrimary = colorResource(id = R.color.dark_onPrimary),
    primaryContainer = colorResource(id = R.color.dark_primaryContainer),
    onPrimaryContainer = colorResource(id = R.color.dark_onPrimaryContainer),
    secondary = colorResource(id = R.color.dark_secondary),
    onSecondary = colorResource(id = R.color.dark_onSecondary),
    secondaryContainer = colorResource(id = R.color.dark_secondaryContainer),
    onSecondaryContainer = colorResource(id = R.color.dark_onSecondaryContainer),
    tertiary = colorResource(id = R.color.dark_tertiary),
    onTertiary = colorResource(id = R.color.dark_onTertiary),
    tertiaryContainer = colorResource(id = R.color.dark_tertiaryContainer),
    onTertiaryContainer = colorResource(id = R.color.dark_onTertiaryContainer),
    error = colorResource(id = R.color.dark_error),
    errorContainer = colorResource(id = R.color.dark_errorContainer),
    onError = colorResource(id = R.color.dark_onError),
    onErrorContainer = colorResource(id = R.color.dark_onErrorContainer),
    background = colorResource(id = R.color.dark_background),
    onBackground = colorResource(id = R.color.dark_onBackground),
    surface = colorResource(id = R.color.dark_surface),
    onSurface = colorResource(id = R.color.dark_onSurface),
    surfaceVariant = colorResource(id = R.color.dark_surfaceVariant),
    onSurfaceVariant = colorResource(id = R.color.dark_onSurfaceVariant),
    outline = colorResource(id = R.color.dark_outline),
    inverseOnSurface = colorResource(id = R.color.dark_inverseOnSurface),
    inverseSurface = colorResource(id = R.color.dark_inverseSurface),
    inversePrimary = colorResource(id = R.color.dark_inversePrimary),
)


/**
 * Base class to extend the material color theme with auxiliary colors that goes
 * beyond the default theme acc. to accomplish your company's corporate identity design
 */
@Immutable
data class ExtendedColors(
    val companyBlue: Color,
    val companyRed: Color,
)

val LocalExtendedColors = staticCompositionLocalOf {
    ExtendedColors(
        companyBlue = Color.Unspecified,
        companyRed = Color.Unspecified,
    )
}

// day colors extented
val lightExtendedColors: ExtendedColors
    @Composable
    get() = ExtendedColors(
        companyBlue = colorResource(id = R.color.light_company_blue),
        companyRed = colorResource(id = R.color.light_company_red),
    )

// night colors extended
val darkExtendedColors: ExtendedColors
    @Composable
    get() = ExtendedColors(
        companyBlue = colorResource(id = R.color.dark_company_blue),
        companyRed = colorResource(id = R.color.dark_company_red),
    )
