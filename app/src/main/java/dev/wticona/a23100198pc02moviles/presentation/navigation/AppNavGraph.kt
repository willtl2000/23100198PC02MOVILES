package dev.wticona.a23100198pc02moviles.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import dev.wticona.a23100198pc02moviles.presentation.home.HomeScreen
import dev.wticona.a23100198pc02moviles.presentation.result.ResultScreen

@Composable
fun AppNavGraph() {

    val nav = rememberNavController()

    NavHost(nav, startDestination = Routes.Home) {

        composable(Routes.Home) {
            HomeScreen(nav)
        }

        composable(
            route = "${Routes.Result}/{values}/{images}",
            arguments = listOf(
                navArgument("values") { type = NavType.StringType },
                navArgument("images") { type = NavType.StringType }
            )
        ) {
            val values = it.arguments!!.getString("values")!!
            val images = it.arguments!!.getString("images")!!
            ResultScreen(values, images)
        }
    }
}
