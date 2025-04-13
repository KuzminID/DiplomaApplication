package com.example.diplomaapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.diplomaapplication.data.local.dao.*
import com.example.diplomaapplication.data.local.entities.*

@Database(
    entities = [
        BaseClasses::class,
        BaseClassStats::class,
        Character::class,
        CharacterStats::class,
        Stat::class,
        Stats::class,
        User::class,
        Enemies::class,
        EnemyStats::class,
        Events::class,
        Locations::class,
        Item::class,
        Inventory::class,
        EnemyLoot::class
    ],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getCharacterDao(): CharacterDao
    abstract fun getEnemiesDao(): EnemyDao
    abstract fun getClassesDao(): ClassDao
    abstract fun getEventsDao(): EventsDao
    abstract fun getStatDao(): StatDao
    abstract fun getStatsDao(): StatsDao
    abstract fun getEnemyStatsDao(): EnemyStatsDao
    abstract fun getLocationsDao(): LocationDao

    abstract fun getItemDao(): ItemDao
    abstract fun getInventoryDao(): InventoryDao
    abstract fun getEnemyLootDao(): EnemyLootDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_db"
                    )
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}