package com.example.diplomaapplication.di.module

import android.content.Context
import com.example.diplomaapplication.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(context: Context) = AppDatabase.getInstance(context)

    @Singleton
    @Provides
    fun provideUserDao(database: AppDatabase) = database.getUserDao()

    @Singleton
    @Provides
    fun provideCharactersDao(database: AppDatabase) = database.getCharacterDao()

    @Singleton
    @Provides
    fun provideEnemyDao(database: AppDatabase) = database.getEnemiesDao()

    @Singleton
    @Provides
    fun provideClassesDao(database: AppDatabase) = database.getClassesDao()

    @Singleton
    @Provides
    fun provideEventsDao(database: AppDatabase) = database.getEventsDao()

    @Singleton
    @Provides
    fun provideStatsDao(database: AppDatabase) = database.getStatsDao()

    @Singleton
    @Provides
    fun provideEnemyStatsDao(database: AppDatabase) = database.getEnemyStatsDao()

    @Singleton
    @Provides
    fun provideStatDao(database: AppDatabase) = database.getStatDao()

    @Singleton
    @Provides
    fun provideLocationDao(database: AppDatabase) = database.getLocationsDao()
}