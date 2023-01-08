package br.com.francivaldo.secreto.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import br.com.francivaldo.secreto.Typography

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)

private val ColorScheme = lightColorScheme(
    primary = primary,
    secondary = surface,
    tertiary = surface,
    background = background,
    onBackground = write

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun SecretoTheme(
    // Dynamic color is available on Android 12+
    content: @Composable () -> Unit
) {
    val colorScheme = ColorScheme
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}