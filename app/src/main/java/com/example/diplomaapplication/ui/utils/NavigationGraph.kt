package com.example.diplomaapplication.ui.utils

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.diplomaapplication.domain.Screens
import com.example.diplomaapplication.ui.views.authorization.AuthorizationView
import com.example.diplomaapplication.ui.views.authorization.AuthorizationViewModel
import com.example.diplomaapplication.ui.views.characters_list.CharactersListView
import com.example.diplomaapplication.ui.views.main_game.GameView

@Composable
fun NavigationGraph(navController: NavHostController) {
    val userId = 1L
    NavHost(
        navController,
        startDestination = Screens.CharactersListScreen.route
    ) {
        composable(
            route = Screens.AuthorizationScreen.route
        ) {
            AuthorizationView(navController, hiltViewModel<AuthorizationViewModel>())
        }

        composable(
            route = Screens.CharactersListScreen.route
        ) {
            CharactersListView(navController, userId)
        }
        composable(
            route = Screens.GameScreen.route,
            arguments = listOf(
                navArgument("character_id") {
                    type = NavType.LongType
                }
            )
        ) { backStackEntry ->
            val characterId: Long = backStackEntry.arguments?.getLong("character_id")!!
            GameView(navController, characterId)
        }
    }
}