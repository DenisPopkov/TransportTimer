package ru.popkov.transport.timer.ui.theme.apptheme

import android.annotation.SuppressLint
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import ru.popkov.transport.timer.dataStore
import ru.popkov.transport.timer.datastore.ThemeViewModel
import ru.popkov.transport.timer.ui.theme.color.DarkColorScheme
import ru.popkov.transport.timer.ui.theme.color.LightColorScheme
import ru.popkov.transport.timer.ui.theme.typography.AppTypography

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val viewModel = remember { ThemeViewModel(context.dataStore) }
    val state = viewModel.state.observeAsState()
    val value = state.value ?: isSystemInDarkTheme()

    LaunchedEffect(viewModel) { viewModel.request() }
    DarkThemeValue.current.value = value

    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography().Typography,
        content = content
    )
}

@SuppressLint("CompositionLocalNaming")
private val DarkThemeValue = compositionLocalOf { mutableStateOf(false) }