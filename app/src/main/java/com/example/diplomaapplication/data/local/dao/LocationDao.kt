package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.local.entities.Locations

@Dao
interface LocationDao : BaseDao<Locations> {
}