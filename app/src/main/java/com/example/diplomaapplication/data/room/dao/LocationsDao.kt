package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.Location

@Dao
abstract class LocationsDao : BaseDao<Location>() {
}