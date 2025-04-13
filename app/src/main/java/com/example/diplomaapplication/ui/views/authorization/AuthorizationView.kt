package com.example.diplomaapplication.ui.views.authorization

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.diplomaapplication.R
import com.example.diplomaapplication.ui.theme.primaryLight

//TODO Симулировать работу на фоне через замер времени в оффлайне и генерировать на основе этого времени
//TODO скип авторизации, приступить к реализации логики игры
@Composable
fun AuthorizationView(navController: NavController, viewModel: AuthorizationViewModel) {
    val viewState by viewModel.uiState.collectAsState()

    BackgroundWithSprite {
        Column {
            Text(
                text = "GameName",
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary
            )

            when (viewState) {
                AuthorizationViewModel.UiState.Registration -> {

                }

                AuthorizationViewModel.UiState.Authorization -> {

                }
            }
        }
    }
}

@Composable
fun BackgroundWithSprite(content: @Composable () -> Unit) {
    // Using surface for creating background with gradient
    Surface(
        color = primaryLight,
        modifier = Modifier.fillMaxSize()
    ) {
        // Adding sprite above background
        Image(
            painter = painterResource(R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(1f),
            contentScale = ContentScale.Crop
        )
        // Placing content above background with sprite
        Box(modifier = Modifier.fillMaxWidth(1f)) { //TODO как развернуть этот Box на весь экран (без учёта паддингов или спейсеров)
            content()
        }
    }
}

@Preview
@Composable
fun preview() {
    BackgroundWithSprite {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 5.dp, vertical = 50.dp)
                .background(MaterialTheme.colorScheme.primary),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Otherworld Hero",
                fontSize = 64.sp,
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center //TODO изучить добавление stroke или borders
            ) //TODO как использовать шрифты и цвета из темы?
            AuthorizationFields()

        }
    }
}

@Composable
fun AuthorizationFields() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(value = "", label = { Text("Email or Username") }, onValueChange = {})
        OutlinedTextField(
            value = "",
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            onValueChange = {}
        )
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(15.dp)
        ) {

        }
    }
}

