package com.example.template.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

/**
 * Esquema de cores baseado na paleta do app de quiz (tema escuro).
 * Troque estas cores em `Color.kt` para adaptar ao seu app.
 */
private val QuizColorScheme = darkColorScheme(
    primary = QuizGold,
    onPrimary = QuizBackground,
    secondary = QuizGoldSoft,
    onSecondary = QuizBackground,
    tertiary = HufflepuffYellow,
    background = QuizBackground,
    onBackground = QuizOnBackground,
    surface = QuizSurface,
    onSurface = QuizOnBackground,
    outline = QuizBorder
)

@Composable
fun AndroidTemplateTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = QuizColorScheme,
        typography = Typography,
        content = content
    )
}
