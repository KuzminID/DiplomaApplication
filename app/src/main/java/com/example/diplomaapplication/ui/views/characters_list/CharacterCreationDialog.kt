package com.example.diplomaapplication.ui.views.characters_list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.diplomaapplication.data.local.entities.BaseClasses

@Composable
fun CharacterCreationDialog(
    onDismissRequest: () -> Unit,
    onCreateCharacter: (String, String) -> Unit,
    classes: List<BaseClasses>
) {
    var characterName by remember { mutableStateOf("") }
    var selectedClass: BaseClasses? = remember { null }

    Dialog(onDismissRequest = onDismissRequest) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text("Введите имя")
                TextField(
                    value = characterName,
                    onValueChange = { characterName = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            BorderStroke(width = 2.dp, Color.Black),
                            shape = RoundedCornerShape(50)
                        ),
                    placeholder = { Text("Введите имя") },
                    singleLine = true
                )

                Text("Выберите класс:")
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(classes) { classItem ->
                        Column() {
                            Text(
                                text = classItem.name,
                                modifier = Modifier.padding(8.dp)
                            )
                            Text(
                                text = classItem.description,
                                modifier = Modifier.padding(8.dp)
                            )
                            Button(onClick = { selectedClass = classItem }) {
                                Text(text = "Выбрать")
                            }
                        }
                    }
                }

                Button(
                    onClick = { onCreateCharacter(characterName, selectedClass?.name!!) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    enabled = characterName.isNotBlank() && selectedClass!=null,
                    shape = RoundedCornerShape(50)
                ) {
                    Text("Создать персонажа")
                }
            }
        }
    }
}