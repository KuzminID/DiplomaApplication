package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.diplomaapplication.data.local.entities.Enemies
import com.example.diplomaapplication.data.local.entities.EnemyStats

@Dao
interface EnemyDao : BaseDao<Enemies> {
    @Query("SELECT * FROM enemies")
    fun getAllEnemies() : List<Enemies>
}

@Dao
interface EnemyStatsDao : BaseDao<EnemyStats> {
}