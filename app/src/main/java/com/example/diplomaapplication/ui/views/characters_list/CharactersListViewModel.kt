package com.example.diplomaapplication.ui.views.characters_list

import android.util.Log
import com.example.diplomaapplication.data.local.entities.BaseClassWithStats
import com.example.diplomaapplication.data.local.entities.Character
import com.example.diplomaapplication.data.local.entities.User
import com.example.diplomaapplication.data.repositories.CharacterRepository
import com.example.diplomaapplication.data.repositories.InitRepository
import com.example.diplomaapplication.data.repositories.UserRepository
import com.example.diplomaapplication.ui.views.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.collections.emptyList

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
    private val userRepository: UserRepository,
    private val initRepository: InitRepository
) : BaseViewModel() {

    private val _userData: MutableStateFlow<User?> = MutableStateFlow(null)
    val userData: StateFlow<User?> = _userData

    private val _characters: MutableStateFlow<List<Character>?> =
        MutableStateFlow(emptyList<Character>())
    val characters: StateFlow<List<Character>?> = _characters

    private val _showCharacterCreationDialog = MutableStateFlow(false)
    val showCharacterCreationDialog: StateFlow<Boolean> = _showCharacterCreationDialog

    private val _classes = MutableStateFlow(emptyList<BaseClassWithStats>())
    val classes: StateFlow<List<BaseClassWithStats>> = _classes

    private var userId: Long = 0

    val TAG = "CharactersListViewModel"

    // Функции для управления диалогом
    fun openCharacterCreationDialog() {
        _showCharacterCreationDialog.value = true
    }

    fun closeCharacterCreationDialog() {
        _showCharacterCreationDialog.value = false
    }

    fun setUserId(userId: Long) {
        launch {
            initRepository.fillTables()
        }
            this.userId = userId
        launch {
            _userData.value = userRepository.getUserById(userId)
            _characters.value = characterRepository.getAllUserCharacters(userId)
            _classes.value = characterRepository.getAllClasses()
        }
    }

    fun createNewCharacter(name: String, className: String) {
        Log.d(TAG, "Creating called")
        launch {
            characterRepository.createCharacter(
                name,
                _classes.value.find { it.baseClass.name == className }?.baseClass?.id!!,
                userId
            )
            _characters.value = characterRepository.getAllUserCharacters(userId)
        }
    }

    fun selectCharacter(characterId: Long) {
        Log.d(TAG, "Select character called")
    }

    fun deleteCharacter(characterId: Long) {
        Log.d(TAG, "Delete character called")
    }

    fun getCharacters(): List<Character>? {
        Log.d(TAG, "Get characters called")
        return emptyList()
    }


}