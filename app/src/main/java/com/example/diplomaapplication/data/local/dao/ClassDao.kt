package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.diplomaapplication.data.local.entities.BaseClassStats
import com.example.diplomaapplication.data.local.entities.BaseClassWithStats
import com.example.diplomaapplication.data.local.entities.BaseClasses

@Dao
interface ClassDao : BaseDao<BaseClasses> {
    @Query("SELECT * FROM base_classes")
    fun getAllClasses(): List<BaseClassWithStats>
}

@Dao
interface ClassStatsDao : BaseDao<BaseClassStats> {

}