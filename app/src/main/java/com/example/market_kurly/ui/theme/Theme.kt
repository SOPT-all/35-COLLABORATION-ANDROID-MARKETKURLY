package com.example.market_kurly.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColor600,
)

private val LightColorScheme = lightColorScheme(
    primary = PrimaryColor600,
)

private val LocalMarketKurlyTypography = staticCompositionLocalOf<MarketKurlyTypography> {
    error("No MarketKurlyTypography provided")
}

object MarketKurlyTheme {
    val typography: MarketKurlyTypography
        @Composable get() = LocalMarketKurlyTypography.current
}

@Composable
fun ProvideMarketKurlyTypography(typography: MarketKurlyTypography, content: @Composable () -> Unit) {
    val provideTypography = remember { typography.copy() }
    provideTypography.update(typography)
    CompositionLocalProvider(
        LocalMarketKurlyTypography provides provideTypography,
        content = content,
    )
}

@Composable
fun MARKETKURLYTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = LightColorScheme
    val typography = marketKurlyTypography()

    ProvideMarketKurlyTypography(typography) {
        MaterialTheme(
            colorScheme = colorScheme,
            content = content,
        )
    }
}
