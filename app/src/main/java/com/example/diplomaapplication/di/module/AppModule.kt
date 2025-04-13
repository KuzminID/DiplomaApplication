package com.example.diplomaapplication.di.module

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.diplomaapplication.data.local.dao.CharacterDao
import com.example.diplomaapplication.data.local.dao.ClassDao
import com.example.diplomaapplication.data.local.dao.EnemyDao
import com.example.diplomaapplication.data.local.dao.EnemyStatsDao
import com.example.diplomaapplication.data.local.dao.EventsDao
import com.example.diplomaapplication.data.local.dao.LocationDao
import com.example.diplomaapplication.data.local.dao.StatDao
import com.example.diplomaapplication.data.local.dao.StatsDao
import com.example.diplomaapplication.data.local.dao.UserDao
import com.example.diplomaapplication.data.repositories.CharacterRepository
import com.example.diplomaapplication.data.repositories.CharacterRepositoryImpl
import com.example.diplomaapplication.data.repositories.EnemyRepository
import com.example.diplomaapplication.data.repositories.EnemyRepositoryImpl
import com.example.diplomaapplication.data.repositories.InitRepository
import com.example.diplomaapplication.data.repositories.UserRepository
import com.example.diplomaapplication.data.repositories.UserRepositoryImpl
import com.example.diplomaapplication.domain.DataHandler
import com.example.diplomaapplication.domain.Generation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule() {

    @Singleton
    @Provides
    fun provideUserRepository(userDao: UserDao): UserRepository = UserRepositoryImpl(userDao)

    @Singleton
    @Provides
    fun provideCharacterRepository(
        characterDao: CharacterDao,
        classesDao: ClassDao
    ): CharacterRepository =
        CharacterRepositoryImpl(characterDao, classesDao)

    @Singleton
    @Provides
    fun provideEnemiesRepository(enemyDao: EnemyDao): EnemyRepository =
        EnemyRepositoryImpl(enemyDao)

    @Singleton
    @Provides
    fun provideInitRepository(
        statDao: StatDao,
        statsDao: StatsDao,
        classDao: ClassDao,
        enemyDao: EnemyDao,
        locationDao: LocationDao,
        eventsDao: EventsDao,
        enemyStatsDao: EnemyStatsDao,
        userDao: UserDao
    ) = InitRepository(
        statDao = statDao,
        statsDao = statsDao,
        baseClassDao = classDao,
        enemyDao = enemyDao,
        locationDao = locationDao,
        eventDao = eventsDao,
        enemyStatsDao = enemyStatsDao,
        userDao = userDao
    )

    @Singleton
    @Provides
    fun provideGeneration(eventsDao: EventsDao,enemyDao: EnemyDao) = Generation(
        eventsDao = eventsDao,
        enemyDao = enemyDao
    )

    @RequiresApi(Build.VERSION_CODES.VANILLA_ICE_CREAM)
    @Singleton
    @Provides
    fun provideGameData(generation: Generation) = DataHandler(
        generator = generation
    )

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext appContext: Context) = appContext
}