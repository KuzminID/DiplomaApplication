package com.example.diplomaapplication.data.repositories

import com.example.diplomaapplication.data.local.dao.EnemyDao
import com.example.diplomaapplication.data.local.entities.Enemies
import javax.inject.Inject

interface EnemyRepository {
    suspend fun createEnemy(enemy: Enemies)
    suspend fun getAllEnemies(): List<Enemies>
}

class EnemyRepositoryImpl @Inject constructor(enemyDao: EnemyDao) : EnemyRepository {
    override suspend fun createEnemy(enemy: Enemies) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllEnemies(): List<Enemies> {
        TODO("Not yet implemented")
    }

}