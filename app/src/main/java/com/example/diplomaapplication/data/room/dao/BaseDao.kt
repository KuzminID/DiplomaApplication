package com.example.diplomaapplication.data.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

abstract class BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    abstract suspend fun insert(item: T): Long

    @Update
    abstract suspend fun update(item: T)

    @Delete
    abstract suspend fun delete(item: T)
}