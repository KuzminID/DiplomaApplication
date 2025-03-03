package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import com.example.diplomaapplication.data.room.entities.CharacterInventory

@Dao
abstract class InventoryDao : BaseDao<CharacterInventory>() {
}