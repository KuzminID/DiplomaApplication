package com.example.diplomaapplication.di.module

import android.app.Application
import com.example.diplomaapplication.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application) = AppDatabase.getInstance(application)

    @Singleton
    @Provides
    fun provideCharacterDao(database : AppDatabase) = database.getCharacterDao()

    @Singleton
    @Provides
    fun provideEnemyDao(database: AppDatabase) = database.getEnemyDao()

    @Singleton
    @Provides
    fun provideEventsDao(database: AppDatabase) = database.getEventsDao()

    @Singleton
    @Provides
    fun provideHistoryDao(database: AppDatabase) = database.getHistoryDao()

    @Singleton
    @Provides
    fun provideInventoryDao(database: AppDatabase) = database.getInventoryDao()

    @Singleton
    @Provides
    fun provideLocationsDao(database: AppDatabase) = database.getLocationsDao()

    @Singleton
    @Provides
    fun provideRecipesDao(database: AppDatabase) = database.getRecipesDao()

    @Singleton
    @Provides
    fun provideStatsDao(database: AppDatabase) = database.getStatsDao()

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase) = database.getUserDao()
}