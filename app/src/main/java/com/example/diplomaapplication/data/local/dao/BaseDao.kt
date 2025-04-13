package com.example.diplomaapplication.data.local.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: T): Long

    @Update
    suspend fun update(item: T)

    @Delete
    suspend fun delete(item: T)
}