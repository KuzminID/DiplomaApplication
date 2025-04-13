package com.example.diplomaapplication.data.repositories

import com.example.diplomaapplication.data.local.dao.CharacterDao
import com.example.diplomaapplication.data.local.dao.ClassDao
import com.example.diplomaapplication.data.local.entities.BaseClassWithStats
import com.example.diplomaapplication.data.local.entities.Character
import javax.inject.Inject

interface CharacterRepository {
    suspend fun createCharacter(name: String, baseClassId: Long, userId: Long)
    suspend fun getCharacter(characterId: Long): Character
    suspend fun getAllUserCharacters(userId: Long): List<Character>?
    suspend fun getAllClasses(): List<BaseClassWithStats>
}

class CharacterRepositoryImpl @Inject constructor(
    private val charactersDao: CharacterDao,
    private val classesDao: ClassDao
) :
    CharacterRepository {

    override suspend fun createCharacter(
        name: String,
        baseClassId: Long,
        userId: Long
    ) {
        val character = Character(null, name, 1, 0, baseClassId, userId)
        charactersDao.createCharacter(character)
    }

    override suspend fun getCharacter(characterId: Long): Character {
        return charactersDao.getCharacterById(characterId)
    }

    override suspend fun getAllUserCharacters(userId: Long): List<Character>? {
        return charactersDao.getAllUserCharacters(userId)
    }

    override suspend fun getAllClasses(): List<BaseClassWithStats> {
        return classesDao.getAllClasses()
    }
}