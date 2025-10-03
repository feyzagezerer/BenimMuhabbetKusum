package com.feyzagezererkaraca.benimmuhabbetkusum.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

// Dark Mode için tema renkleri
private val DarkColorScheme = darkColorScheme(
    primary = AppColors.NavBarBackground,
    secondary = AppColors.CardGradientEnd,
    tertiary = AppColors.NavBarIndicator,

    background = AppColors.BackgroundNutrition,
    surface = AppColors.BackgroundHome,

    onPrimary = AppColors.White,
    onSecondary = AppColors.White,
    onTertiary = AppColors.White,
    onBackground = AppColors.White,
    onSurface = AppColors.White,
)

// Light Mode için tema renkleri
private val LightColorScheme = lightColorScheme(
    primary = AppColors.NavBarBackground,
    secondary = AppColors.CardGradientEnd,
    tertiary = AppColors.NavBarIndicator,

    background = AppColors.BackgroundHome,
    surface = AppColors.White,

    onPrimary = AppColors.White,
    onSecondary = AppColors.White,
    onTertiary = AppColors.White,
    onBackground = AppColors.Black,
    onSurface = AppColors.Black,
)

@Composable
fun BenimMuhabbetKusumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}