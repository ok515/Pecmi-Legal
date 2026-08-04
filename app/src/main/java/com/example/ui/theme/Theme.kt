package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val PikoneLegalColorScheme = darkColorScheme(
    primary = PikonePrimary,
    onPrimary = PikoneTextPrimary,
    primaryContainer = PikonePrimaryDark,
    onPrimaryContainer = PikoneTextPrimary,
    secondary = PikonePrimaryLight,
    onSecondary = PikoneTextPrimary,
    background = PikoneBgDark,
    onBackground = PikoneTextPrimary,
    surface = PikoneSurfaceCard,
    onSurface = PikoneTextPrimary,
    surfaceVariant = PikoneSurfaceGlass,
    onSurfaceVariant = PikoneTextSecondary,
    outline = PikoneCardBorder
)

@Composable
fun PikoneLegalTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = PikoneLegalColorScheme,
        typography = Typography,
        content = content
    )
}
