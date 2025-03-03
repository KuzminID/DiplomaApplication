package com.example.diplomaapplication

import android.util.Log
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.diplomaapplication.data.room.AppDatabase
import com.example.diplomaapplication.data.room.dao.CharacterDao
import com.example.diplomaapplication.data.room.entity.BaseClasses
import com.example.diplomaapplication.data.room.entity.Locations
import com.example.diplomaapplication.data.room.entity.User
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CharacterDaoUnitTest {
    private lateinit var db: AppDatabase
    private lateinit var characterDao: CharacterDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        characterDao = db.getCharacterDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun userCreationTest() = runTest() {

        val firstUser: User = User(
            id = 0,
            login = "firstUserLogin",
            email = "firstUserEmail@email.com",
            password = "firstUserPassword"
        )

        val secondUser = User(
            id = 1,
            login = "secondUserLogin",
            email = "secondUserEmail@email.com",
            password = "secondUserPassword"
        )

        characterDao.createUser(firstUser)
        characterDao.createUser(secondUser)
        val dbFirstUser = characterDao.getUserByID(firstUser.id ?: 0)
        val dbSecondUser = characterDao.getUserByID(secondUser.id ?: 0)
        assertEquals(firstUser, dbFirstUser)
        assertEquals(secondUser, dbSecondUser)
    }

    @Test
    fun characterCreationTest() = runTest() {
        val firstUser: User = User(
            id = 0,
            login = "firstUserLogin",
            email = "firstUserEmail@email.com",
            password = "firstUserPassword"
        )

        characterDao.createUser(firstUser)

        val firstLocation = Locations(
            id = 0,
            name = "Forest",
            description = "Forest description",
            dropRateMultiplier = 0.0,
            enemyStatMultiplier = 0.0
        )

        characterDao.createLocation(firstLocation)

        val baseClass = BaseClasses(
            id = 0,
            name = "Warrior",
            description = "Warrior description"
        )

        characterDao.createBaseClass(baseClass)

        val firstCharacter = Character(
            id = 0,
            name = "firstUserFirstCharacter",
            userID = firstUser.id!!,
            lvl = 1,
            exp = 0,
            currentLocation = firstLocation.id!!,
            baseClassID = baseClass.id!!,
            capacity = 10
        )

        characterDao.createCharacter(firstCharacter)

        val secondCharacter = Character(
            id = 1,
            name = "firstUserSecondCharacter",
            userID = firstUser.id,
            lvl = 1,
            exp = 0,
            currentLocation = firstLocation.id,
            baseClassID = baseClass.id,
            capacity = 10
        )
        characterDao.createCharacter(secondCharacter)

        val characters = listOf<Character>(firstCharacter, secondCharacter)

        val dbCharacters = characterDao.getCharacters(firstUser.id)

        Log.d("CharacterCreation", characters.toString())
        Log.d("CharacterCreation", dbCharacters.toString())

        assertEquals(characters, dbCharacters)
    }
}