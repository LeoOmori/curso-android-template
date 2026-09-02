package com.example.template

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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

/** Nomes das rotas do app. Adicione novas telas aqui. */
object AppRoutes {
    const val HOME = "home"
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
            HomeScreen()
        }

        // Para adicionar uma tela nova:
        // 1. crie o Composable dela em screen/
        // 2. adicione a rota em AppRoutes
        // 3. registre aqui com composable("...") { SuaTela(...) }
        // 4. navegue com navController.navigate("...")
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    App()
}
