package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = NavyBlue,
    onPrimary = Color.White,
    primaryContainer = LightBlueBg,
    onPrimaryContainer = DeepNavy,
    secondary = ForestGreen,
    onSecondary = Color.White,
    secondaryContainer = LightGreenBg,
    onSecondaryContainer = DeepGreen,
    tertiary = SaffronOrange,
    onTertiary = Color.White,
    tertiaryContainer = LightAmberBg,
    onTertiaryContainer = SaffronOrange,
    background = SurfaceBg,
    onBackground = DarkText,
    surface = SurfaceCard,
    onSurface = DarkText,
    surfaceVariant = Color(0xFFF1F5F9),
    onSurfaceVariant = MediumText,
    outline = CardBorder
)

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF90CAF9),
    onPrimary = DeepNavy,
    primaryContainer = Color(0xFF1E3A8A),
    onPrimaryContainer = Color(0xFFDBEAFE),
    secondary = Color(0xFFA7F3D0),
    onSecondary = DeepGreen,
    secondaryContainer = Color(0xFF065F46),
    onSecondaryContainer = Color(0xFFD1FAE5),
    tertiary = Color(0xFFFDBA74),
    onTertiary = Color(0xFF7C2D12),
    tertiaryContainer = Color(0xFF9A3412),
    onTertiaryContainer = Color(0xFFFFEDD5),
    background = Color(0xFF0B1329),
    onBackground = Color(0xFFF8FAFC),
    surface = Color(0xFF111C3A),
    onSurface = Color(0xFFF8FAFC),
    surfaceVariant = Color(0xFF1E293B),
    onSurfaceVariant = Color(0xFFCBD5E1),
    outline = Color(0xFF334155)
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false, // Keep consistent branding colors
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
