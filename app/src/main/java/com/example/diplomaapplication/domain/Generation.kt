package com.example.diplomaapplication.domain

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.diplomaapplication.data.local.dao.EnemyDao
import com.example.diplomaapplication.data.local.dao.EventsDao
import com.example.diplomaapplication.data.local.entities.Enemies
import com.example.diplomaapplication.data.local.entities.Events
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Random
import javax.inject.Inject

class Generation @Inject constructor(val eventsDao: EventsDao,val enemyDao: EnemyDao) {
    private val randomEventGenerator = Random()
    private val events : List<Events> by lazy {
        eventsDao.getAllEvents().sortedBy { it.chance }
    }
    private val enemies : List<Enemies> by lazy {
        enemyDao.getAllEnemies().sortedBy { it.chance }
    }

    /**
     * Returns index of generatedElement
     */
    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    private fun generationCore(dropChances : List<Double>) : Int {
        val totalChance = dropChances.sumOf { it }
        val randomValue = randomEventGenerator.nextDouble(0.0,totalChance)

        var currentSum = 0.0
        var index = 0
        for (chance in dropChances) {
            currentSum+=chance
            if (randomValue<=currentSum) {
                return index
            } else {
                index++
            }
        }
        return 0
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun generateRandomEvent(): Events {
        val index = generationCore(events.map { it.chance })
        return events[index]
    }

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    fun generateRandomEnemy() : Enemies {
        val index = generationCore(enemies.map { it.chance })
        return enemies[index]
    }
}