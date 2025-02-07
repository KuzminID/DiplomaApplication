package com.example.diplomaapplication.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.diplomaapplication.data.room.entities.*
import com.example.diplomaapplication.data.room.utils.JsonConverter

@Database(entities = [
    Users::class, Characters::class,
    Class::class, CharacterStat::class,
    Skill::class, CharacterSkill::class,
    SkillBonus::class, Item::class,
    CharacterInventory::class, CharacterEquipment::class,
    Location::class, Event::class,
    Enemy::class, EnemyLoot::class,
    Recipe::class, Ingredient::class,
    LearnedRecipe::class, NPC::class, Quest::class],
    version = 1)
@TypeConverters(JsonConverter::class)
class AppDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance==null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    ).build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun createOpenHelper(config: DatabaseConfiguration): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }
}