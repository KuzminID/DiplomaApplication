package com.example.diplomaapplication.data.repositories

import com.example.diplomaapplication.data.local.dao.EnemyLootDao
import com.example.diplomaapplication.data.local.dao.InventoryDao
import com.example.diplomaapplication.data.local.dao.ItemDao
import com.example.diplomaapplication.data.local.entities.Item
import javax.inject.Inject

// Add to data/repositories/ItemRepository.kt
interface ItemRepository {
    suspend fun getAllItems(): List<Item>
    suspend fun getItemById(itemId: Long): Item
    suspend fun getLootForEnemy(enemyId: Long): List<Item>
}

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
    private val enemyLootDao: EnemyLootDao
) : ItemRepository {
    override suspend fun getAllItems(): List<Item> = itemDao.getAllItems()
    override suspend fun getItemById(itemId: Long): Item = itemDao.getItemById(itemId)
    override suspend fun getLootForEnemy(enemyId: Long): List<Item> = enemyLootDao.getLootForEnemy(enemyId)
}

// Add to data/repositories/InventoryRepository.kt
interface InventoryRepository {
    suspend fun getCharacterInventory(characterId: Long): List<Item>
    suspend fun addItemToInventory(characterId: Long, itemId: Long, amount: Int = 1)
    suspend fun useItem(characterId: Long, itemId: Long, amount: Int = 1)
}

class InventoryRepositoryImpl @Inject constructor(
    private val inventoryDao: InventoryDao,
    private val itemDao: ItemDao
) : InventoryRepository {
    override suspend fun getCharacterInventory(characterId: Long): List<Item> =
        inventoryDao.getCharacterItems(characterId)

    override suspend fun addItemToInventory(characterId: Long, itemId: Long, amount: Int) {
        inventoryDao.updateItemQuantity(characterId, itemId, amount)
    }

    override suspend fun useItem(characterId: Long, itemId: Long, amount: Int) {
        inventoryDao.updateItemQuantity(characterId, itemId, -amount)
    }
}