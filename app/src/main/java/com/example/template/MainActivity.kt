package com.example.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.template.screen.DetailScreen
import com.example.template.screen.HomeScreen
import com.example.template.ui.theme.AndroidTemplateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    AndroidTemplateTheme {
        val navController = rememberNavController()
        AppNavHost(navController = navController)
    }
}

/** Nomes das rotas e helpers para montá-las. */
object AppRoutes {
    const val HOME = "home"
    const val DETAIL = "detail/{postId}"

    fun detail(postId: Int) = "detail/$postId"
}

@Composable
fun AppNavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.HOME
    ) {
        composable(AppRoutes.HOME) {
            HomeScreen(
                onPostClick = { postId ->
                    navController.navigate(AppRoutes.detail(postId))
                }
            )
        }

        composable(
            route = AppRoutes.DETAIL,
            arguments = listOf(navArgument("postId") { type = NavType.IntType })
        ) { backStackEntry ->
            val postId = backStackEntry.arguments?.getInt("postId") ?: 0
            DetailScreen(
                postId = postId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}
