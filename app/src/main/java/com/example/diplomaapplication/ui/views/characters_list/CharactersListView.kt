package com.example.diplomaapplication.ui.views.characters_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.diplomaapplication.data.local.entities.Character
import com.example.diplomaapplication.data.local.entities.User
import com.example.diplomaapplication.domain.Screens

@Composable
fun CharactersListView(navController: NavController, userId: Long) {

    val viewModel = hiltViewModel<CharactersListViewModel>()
    viewModel.setUserId(userId)
    val userData: User? by viewModel.userData.collectAsState()
    val showDialog by viewModel.showCharacterCreationDialog.collectAsState()
    val classes by viewModel.classes.collectAsState()

    val characters: List<Character>? by viewModel.characters.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 25.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (userData != null) {
            UserGreeting(userData!!.username)
        } else {
            UserGreeting("Гость")
        }

        if (showDialog) {
            CharacterCreationDialog(
                onDismissRequest = { viewModel.closeCharacterCreationDialog() },
                onCreateCharacter = { name, baseClassName ->
                    viewModel.createNewCharacter(name, baseClassName)
                    viewModel.closeCharacterCreationDialog()
                },
                classes = classes.map { it.baseClass }
            )
        }

        if (characters.isNullOrEmpty()) {
            CreateNewCharacterItem(onCreateNewCharacterClicked = { viewModel.openCharacterCreationDialog() })
        } else {
            characters!!.forEach { character ->
                CharactersItem(character.name,
                    classes.find { it.baseClass.id == character.baseClassId }?.baseClass?.name!!,
                    character.level,
                    onEnterClicked = {

                        navController.navigate(Screens.GameScreen.createRoute(character))
                    })
            }
            if (characters!!.size < 4) {
                CreateNewCharacterItem(onCreateNewCharacterClicked = { viewModel.openCharacterCreationDialog() })
            }
        }
    }
}

@Composable
fun UserGreeting(username: String) {
    Text(
        text = "Привет, $username",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(top = 16.dp, bottom = 25.dp)
    )
}

@Composable
fun CharactersItem(
    characterName: String,
    characterClassName: String,
    characterLevel: Int,
    onEnterClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(text = "Name = $characterName")
            Text(text = "Class = $characterClassName")
            Text(text = "Level = $characterLevel")
        }

        Button(onClick = { onEnterClicked() }) {
            Text("Войти")
        }
    }
}

@Composable
fun CreateNewCharacterItem(onCreateNewCharacterClicked: () -> Unit) {
    Button(
        onClick = { onCreateNewCharacterClicked() },
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text("Создать нового персонажа")
    }
}