package com.example.diplomaapplication.domain

import com.example.diplomaapplication.data.local.entities.Character

sealed class Screens(val route: String) {
    object AuthorizationScreen : Screens(route = "auth_screen")
    object CharactersListScreen : Screens(route = "characters_screen")
    object GameScreen : Screens(route = "main_game_screen/{character_id}") {
        fun createRoute(character: Character): String {
            return "main_game_screen/${character.id}"
        }
    }
}