package com.example.diplomaapplication.ui.views.main_game

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.diplomaapplication.R
import com.example.diplomaapplication.data.local.entities.Enemies

private val TAG = "GAME_VIEW"

@RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
@Composable
fun GameView(navController: NavController, characterId: Long) {
    val viewModel = hiltViewModel<GameViewModel>()
    viewModel.getCharacter(characterId)

    val events by viewModel.eventHistory.collectAsState()
    val character by viewModel.character.collectAsState()
    val gameState by viewModel.gameState.collectAsState()
    val currentEnemy by viewModel.currentEnemy.collectAsState()
    val inventory by viewModel.inventory.collectAsState()
    val characterStats by viewModel.characterStats.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.background_image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(1f),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {
            // Add inventory button to top bar
            CharacterTopBar(
                character?.name ?: "",
                inventory.size,
                onInventoryClick = { /* Show inventory */ }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Enhanced event log with better formatting
            EventsList(
                events = events,
                modifier = Modifier.weight(1f))

                // Show enemy info when in battle
                if (currentEnemy != null) {
                    EnemyInfo(currentEnemy!!)
                }

                        // Show character stats
                        CharacterStats(characterStats)

                // Action buttons based on game state
                val actions = when (gameState) {
            GameState.Battle -> {
                listOf(
                    "Attack" to { viewModel.attack() },
                    "Defend" to { viewModel.defend() },
                    "Use Item" to { /* Show item selection */ }
                )
            }
                GameState.BeforeBattle -> GameState.BeforeBattle.actions.map { it.name }
                GameState.CollectingTreasure -> GameState.CollectingTreasure.actions.map { it.name }
                GameState.Exploring -> GameState.Exploring.actions.map { it.name }
                GameState.Resting -> GameState.Resting.actions.map { it.name }
                GameState.Trapped -> GameState.Trapped.actions.map { it.name }
            }
//
//            LazyVerticalGrid(
//                columns = GridCells.Fixed(2),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(vertical = 5.dp),
//                horizontalArrangement = Arrangement.spacedBy(8.dp),
//                verticalArrangement = Arrangement.spacedBy(8.dp)
//            ) {
//                items(actions) { action ->
//                    ActionButton(action = action)
//                }
//            }
            LazyVerticalGrid(
                columns = if (actions.size < 2) GridCells.Fixed(1) else GridCells.Fixed(2),
                modifier = Modifier.fillMaxWidth().padding(vertical = 5.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(actions) { action ->
                    Box(Modifier.fillMaxWidth()) {
                        ActionButton(action)
                    }
                }
            }

            BottomNavigationBar()
        }
    }
}


@Composable
fun EnemyInfo(enemy: Enemies) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = enemy.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = enemy.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun CharacterStats(stats: Map<String, Int>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text("Stats:", style = MaterialTheme.typography.headlineSmall)
            stats.forEach { (stat, value) ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(stat)
                    Text(value.toString())
                }
            }
        }
    }
}

@Composable
fun CharacterTopBar(modifier: Modifier = Modifier, characterName: String) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_character),
                contentDescription = "Character",
                modifier = Modifier
                    .size(48.dp)
                    .clip(
                        CircleShape
                    )
                    .background(Color.White)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(text = characterName, modifier = Modifier.padding(bottom = 5.dp))
                Box( //TODO переделать, для заполнения от здоровья персонажа
                    modifier = Modifier
                        .width(150.dp)
                        .height(12.dp)
                        .border(1.dp, Color.White, RoundedCornerShape(4.dp))
                        .padding(1.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(100.dp)
                            .height(10.dp)
                            .background(Color.Red, RoundedCornerShape(3.dp))
                    )
                }
            }
        }

        Row {
            Icon(
                painter = painterResource(id = R.drawable.ic_map),
                contentDescription = "Map",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { /*TODO Действие при нажатии */ }
            )
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_settings),
                contentDescription = "Settings",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { /*TODO Действие при нажатии */ }
            )
        }
    }
}

@Composable
fun EventsList(events: List<String>, modifier: Modifier = Modifier) {
    Log.d(TAG,"Events ${events.size}")
    val listState = rememberLazyListState()

    // AutomaticScroll to last element of list TODO fix, with this scroll it is not possible to user scroll
    LaunchedEffect(events) {
        if (events.isNotEmpty()) {
            listState.animateScrollToItem(events.size - 1)
        }
    }

    Column(modifier = modifier) {
        Text(
            text = "События",
            textAlign = TextAlign.Center,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth()
        )
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 8.dp),
            color = Color.White.copy(alpha = 0.5f)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            state = listState,
        ) {
            items(events) { event ->
                Text(
                    text = event,
                    color = Color.White,
                    modifier = Modifier.padding(16.dp)
                )
                HorizontalDivider(
                    color = Color.White.copy(alpha = 0.2f)
                )
            }
        }
    }
}

@Composable
fun ActionButton(action: String) {
    TextButton(
        onClick = {/*TODO действия при нажатии*/ },
        modifier = Modifier
            .height(64.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(MaterialTheme.colorScheme.primary)
    ) {
        Text(
            text = action,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(
        R.drawable.ic_home,
        R.drawable.ic_inventory,
        R.drawable.ic_stats,
        R.drawable.ic_guide
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onBackground)
            .padding(vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        items.forEach { iconRes ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .width(70.dp)
                    .clickable { /* TODO Действие при нажатии */ }
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = "nav_icon",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize(0.5f)
                    )
                }
            }
        }
    }
}