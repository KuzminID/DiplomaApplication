package com.example.diplomaapplication.domain

import com.example.diplomaapplication.data.local.entities.FulLCharacterData
import com.example.diplomaapplication.data.local.entities.FullEnemyData
import com.example.diplomaapplication.ui.views.main_game.GameState

data class GameData(
    val character : FulLCharacterData,
    val currentEnemy : FullEnemyData?,
    val currentState : GameState
)
