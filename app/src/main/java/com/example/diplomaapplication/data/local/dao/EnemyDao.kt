package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Enemy

@Dao
abstract class EnemyDao : BaseDao<Enemy>() {
}