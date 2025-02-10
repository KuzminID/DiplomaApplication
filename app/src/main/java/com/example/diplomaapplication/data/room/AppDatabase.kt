package com.example.diplomaapplication.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.diplomaapplication.data.room.entity.*
import kotlinx.coroutines.CoroutineScope

enum class entities {
    BaseClasses,
    BaseClassStatValue
}

@Database(entities = [
    User::class, Characters::class,Characters::class,
    BaseClasses::class, BaseClassStatValue::class,
    Stat::class, StatValue::class
    ],
    version = 1)
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

fun loadEntityFromJson(context : Context, scope : CoroutineScope) {
    val db = AppDatabase.getInstance(context)

}