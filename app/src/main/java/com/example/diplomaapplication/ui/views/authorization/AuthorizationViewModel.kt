package com.example.diplomaapplication.ui.views.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaapplication.data.repositories.UserRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthorizationViewModel() : ViewModel() {

    private val _eventState = MutableStateFlow(EventState.Nothing)
    val eventState: StateFlow<EventState> = _eventState

    private val _uiState = MutableStateFlow(UiState.Authorization)
    val uiState: StateFlow<UiState> = _uiState

    var errorMessage: String = ""

    private lateinit var userRepository: UserRepositoryImpl

    private var userId: Long = 0


    fun newUserRegistration(username: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _eventState.value = EventState.Loading
                userId = userRepository.createUser(username, email, password)
                _eventState.value = EventState.Success
            } catch (e: Exception) {
                _eventState.value = EventState.Error
                errorMessage = e.message.toString()
                e.printStackTrace()
            }
        }
    }

    fun userAuthorization(username: String, email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _eventState.value = EventState.Loading
                userId = userRepository.authorization(email, username, password)
                _eventState.value = EventState.Success
            } catch (e: Exception) {
                _eventState.value = EventState.Error
                errorMessage = e.message.toString()
                e.printStackTrace()
            }
        }
    }


    fun checkEmail(email: String?): Boolean {
        val emailRegex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")
        return email?.matches(emailRegex) == true
    }

    //TODO регулярные выражения для проверки почты
    fun alterUiState() {
        _uiState.value =
            when (_uiState.value) {
                UiState.Registration -> UiState.Authorization
                UiState.Authorization -> UiState.Registration
            }
    }

    enum class EventState {
        Loading,
        Error,
        Success,
        Nothing
    }

    enum class UiState {
        Registration,
        Authorization
    }
}