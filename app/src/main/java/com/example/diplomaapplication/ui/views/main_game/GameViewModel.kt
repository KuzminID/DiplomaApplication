package com.example.diplomaapplication.ui.views.main_game

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.diplomaapplication.data.local.entities.Character
import com.example.diplomaapplication.data.local.entities.Enemies
import com.example.diplomaapplication.data.local.entities.Item
import com.example.diplomaapplication.data.repositories.CharacterRepository
import com.example.diplomaapplication.data.repositories.InventoryRepository
import com.example.diplomaapplication.data.repositories.ItemRepository
import com.example.diplomaapplication.domain.DataHandler
import com.example.diplomaapplication.ui.views.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@HiltViewModel
class GameViewModel @Inject constructor(
    val characterRepository: CharacterRepository,
    val gameData: DataHandler,
    val itemRepository: ItemRepository,
    val inventoryRepository: InventoryRepository
) : BaseViewModel() {

    private val _character: MutableStateFlow<Character?> = MutableStateFlow(null)
    val character: StateFlow<Character?> = _character

    private val _gameState: MutableStateFlow<GameState> = MutableStateFlow(GameState.Resting)
    val gameState: StateFlow<GameState> = _gameState

    private val _eventsHistory: MutableStateFlow<MutableList<String>> =
        MutableStateFlow(mutableListOf())
    val eventHistory: StateFlow<List<String>> = _eventsHistory

    private val _currentEnemy: MutableStateFlow<Enemies?> = MutableStateFlow(null)
    val currentEnemy: StateFlow<Enemies?> = _currentEnemy

    private val _inventory: MutableStateFlow<List<Item>> = MutableStateFlow(emptyList())
    val inventory: StateFlow<List<Item>> = _inventory

    private val _characterStats: MutableStateFlow<Map<String, Int>> = MutableStateFlow(emptyMap())
    val characterStats: StateFlow<Map<String, Int>> = _characterStats

    var job = launch {
        while (true) {
            val event = gameData.getEvent()
            when (event.type) {
                1 -> {
                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add(event.name + " " + gameData.getEnemy().name)
                        _gameState.value = GameState.BeforeBattle
                        delay(2000)
                        _gameState.value = GameState.Battle
                    }
                }

                2 -> {
                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add(event.name)
                    }
                    _gameState.value = GameState.CollectingTreasure
                }

                3 -> {
                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add(event.name)
                    }
                    _gameState.value = GameState.Resting
                }

                4 -> {
                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add(event.name)
                    }
                    _gameState.value = GameState.Trapped
                }
            }
            _gameState.value = GameState.Exploring
            delay(3000)
        }
    }

    fun attack() {
        launch {
            val enemy = _currentEnemy.value ?: return@launch
            val character = _character.value ?: return@launch

            // Simple battle logic - in a real game you'd want more complexity
            val enemyDamage = (1..5).random()
            val characterDamage = (3..8).random()

            // Update battle log
            _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                add("${character.name} attacks ${enemy.name} for $characterDamage damage!")
                add("${enemy.name} attacks back for $enemyDamage damage!")
            }

            // Check if enemy is defeated
            if (Random.nextDouble() < 0.3) { // 30% chance to defeat for demo
                val loot = itemRepository.getLootForEnemy(enemy.id!!)
                val expGained = (5..20).random()

                // Add loot to inventory
                loot.forEach { item ->
                    inventoryRepository.addItemToInventory(character.id!!, item.id!!)
                }

                // Update battle log
                _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                    add("${character.name} defeated ${enemy.name}!")
                    if (loot.isNotEmpty()) {
                        val lootText = loot.joinToString { "${it.name} * 1" }
                        add("Received items: $lootText")
                    }
                    add("Gained $expGained experience!")
                }

                _currentEnemy.value = null
                _gameState.value = GameState.Exploring
            }
        }
    }

    fun defend() {
        launch {
            val enemy = _currentEnemy.value ?: return@launch
            val character = _character.value ?: return@launch

            // Defending reduces damage
            val enemyDamage = (0..2).random()

            _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                add("${character.name} takes a defensive stance!")
                add("${enemy.name} attacks for $enemyDamage damage!")
            }
        }
    }

    fun useItem(item: Item) {
        launch {
            val character = _character.value ?: return@launch

            when (item.type) {
                "consumable" -> {
                    // Apply item effect
                    inventoryRepository.useItem(character.id!!, item.id!!)

                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add("${character.name} used ${item.name}!")
                        // Add specific effects based on item
                    }
                }
                else -> {
                    _eventsHistory.value = _eventsHistory.value.toMutableList().apply {
                        add("Can't use ${item.name} right now!")
                    }
                }
            }
        }
    }

    // Update getCharacter to also load inventory
    fun getCharacter(characterId: Long) {
        launch {
            val character = characterRepository.getCharacter(characterId)
            _character.value = character
            _inventory.value = inventoryRepository.getCharacterInventory(characterId)

            // Load character stats (simplified)
            _characterStats.value = mapOf(
                "Health" to 100,
                "Attack" to 10,
                "Defense" to 5
            )
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}

sealed class GameState(val actions: List<InteractionButtons>) {
    object Battle : GameState(listOf(
            ActionButtons.attackButton, ActionButtons.defendButton,
            ActionButtons.potionButton, ActionButtons.runAwayButton))
    object BeforeBattle : GameState(listOf(
        ActionButtons.attackButton,
        ActionButtons.runAwayButton))
    object Exploring : GameState(emptyList())
    object Resting : GameState(listOf(
        ActionButtons.cancelRestingButton))
    object CollectingTreasure : GameState(listOf(
        ActionButtons.collectTreasuresButton))
    object Trapped : GameState(listOf(
        ActionButtons.freeFromTrapButton))
}

object ActionButtons {
    val attackButton = InteractionButtons(1, "Атака")
    val defendButton = InteractionButtons(2, "Защита")
    val potionButton = InteractionButtons(3, "Зелье")
    val runAwayButton = InteractionButtons(4, "Сбежать")
    val cancelRestingButton = InteractionButtons(5, "Прервать отдых")
    val collectTreasuresButton = InteractionButtons(6, "Собрать сокровища")
    val freeFromTrapButton = InteractionButtons(7, "Выбраться")
}

data class InteractionButtons(
    val id: Int,
    val name: String
)