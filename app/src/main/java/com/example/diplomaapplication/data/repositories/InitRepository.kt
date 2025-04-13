package com.example.diplomaapplication.data.repositories

import com.example.diplomaapplication.data.local.dao.ClassDao
import com.example.diplomaapplication.data.local.dao.EnemyDao
import com.example.diplomaapplication.data.local.dao.EnemyStatsDao
import com.example.diplomaapplication.data.local.dao.EventsDao
import com.example.diplomaapplication.data.local.dao.LocationDao
import com.example.diplomaapplication.data.local.dao.StatDao
import com.example.diplomaapplication.data.local.dao.StatsDao
import com.example.diplomaapplication.data.local.dao.UserDao
import com.example.diplomaapplication.data.local.entities.*
import com.example.diplomaapplication.data.local.entities.Stat
import java.lang.Boolean.FALSE
import java.lang.Boolean.TRUE
import javax.inject.Inject

class InitRepository @Inject constructor(
    val statDao: StatDao,
    val statsDao: StatsDao,
    val baseClassDao: ClassDao,
    val enemyDao: EnemyDao,
    val locationDao: LocationDao,
    val eventDao: EventsDao,
    val enemyStatsDao: EnemyStatsDao,
    val userDao: UserDao
) {
    suspend fun fillTables() {
        fillStatTable()
        fillStatsTable()
        fillBaseClassTable()
        fillEnemyTable()
        fillLocationTable()
        fillEventTable()
        fillEnemyTable()
        fillEnemyStatsTable()
        fillUserTable()
    }

    private suspend fun fillStatTable() {
        val stats: List<Stat> = listOf(
            Stat(1, TRUE, "Strength", "Физическая сила"),
            Stat(2, FALSE, "Dexterity", "Ловкость"),
            Stat(3, FALSE, "Intelligence", "Интеллект"),
            Stat(4, FALSE, "Wisdom", "Мудрость"),
            Stat(5, FALSE, "Constitution", "Телосложение")
        )

        stats.map { statDao.insert(it) }
    }

    private suspend fun fillBaseClassTable() {
        val baseClasses: List<BaseClasses> = listOf(
            BaseClasses(1, "Warrior", "Класс воинов, использующих мечи и щиты."),
            BaseClasses(2, "Mage", "Класс магов, специализирующихся на магии.")
        )

        baseClasses.map { baseClassDao.insert(it) }
    }

    private suspend fun fillEnemyTable() {
        val enemies: List<Enemies> = listOf(
            Enemies(1, "Goblin", "Маленький зеленый монстр.", 0.5),
            Enemies(2, "Skeleton", "Костяной скелет.", 0.3),
            Enemies(3, "Dragon", "Огромное крылатое существо.", 0.2)
        )

        enemies.map { enemyDao.insert(it) }
    }

    private suspend fun fillLocationTable() {
        val locations: List<Locations> = listOf(
            Locations(1, "Forest", "Темная лесистая местность."),
            Locations(2, "Cave", "Угнетающая пещера."),
            Locations(3, "Desert", "Пустыня под палящим солнцем.")
        )

        locations.map { locationDao.insert(it) }
    }

    private suspend fun fillEventTable() {
        val events: List<Events> = listOf(
            Events(1, 1, "Encounter", 0.21),
            Events(2, 2, "Treasure Found", 0.1),
            Events(3, 3, "Rest", 0.13),
            Events(4 ,4, "Trap", 0.1)
        )

        events.map { eventDao.insert(it) }
    }

    private suspend fun fillEnemyStatsTable() {
        val enemyStats: List<EnemyStats> = listOf(
            EnemyStats(1, 1, 1),
            EnemyStats(2, 2, 1),
            EnemyStats(3, 3, 1)
        )

        enemyStats.map { enemyStatsDao.insert(it) }
    }

    private suspend fun fillStatsTable() {
        val stats: List<Stats> = listOf(
            Stats(1, 1, 10),
            Stats(2, 2, 20),
            Stats(3, 3, 30),
            Stats(4, 4, 40),
            Stats(5, 5, 50)
        )

        stats.map { statsDao.insert(it) }
    }

    private suspend fun fillUserTable() {
        val users: List<User> = listOf(
            User(1, "Player1","player1@example.com", "password1"),
            User(2, "Player2","player2@example.com", "password2")
        )

        users.map { userDao.insert(it) }
    }
}