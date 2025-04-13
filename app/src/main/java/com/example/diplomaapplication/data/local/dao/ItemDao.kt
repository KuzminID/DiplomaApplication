package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.diplomaapplication.data.local.entities.Inventory
import com.example.diplomaapplication.data.local.entities.Item

// Add to data/local/dao/ItemDao.kt
@Dao
interface ItemDao : BaseDao<Item> {
    @Query("SELECT * FROM items")
    fun getAllItems(): List<Item>

    @Query("SELECT * FROM items WHERE id = :itemId")
    fun getItemById(itemId: Long): Item
}

// Add to data/local/dao/InventoryDao.kt
@Dao
interface InventoryDao {
    @Insert
    suspend fun addItemToInventory(inventory: Inventory)

    @Query("UPDATE inventory SET quantity = quantity + :amount WHERE character_id = :characterId AND item_id = :itemId")
    suspend fun updateItemQuantity(characterId: Long, itemId: Long, amount: Int)

    @Query("SELECT * FROM inventory WHERE character_id = :characterId")
    suspend fun getCharacterInventory(characterId: Long): List<Inventory>

    @Query("SELECT i.* FROM items i INNER JOIN inventory inv ON i.id = inv.item_id WHERE inv.character_id = :characterId")
    suspend fun getCharacterItems(characterId: Long): List<Item>
}

// Add to data/local/dao/EnemyLootDao.kt
@Dao
interface EnemyLootDao {
    @Query("SELECT i.* FROM items i INNER JOIN enemy_loot el ON i.id = el.item_id WHERE el.enemy_id = :enemyId")
    suspend fun getLootForEnemy(enemyId: Long): List<Item>
}