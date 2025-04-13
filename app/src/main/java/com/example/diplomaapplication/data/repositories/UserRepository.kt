package com.example.diplomaapplication.data.repositories

import com.example.diplomaapplication.data.local.dao.UserDao
import com.example.diplomaapplication.data.local.entities.User
import javax.inject.Inject

interface UserRepository {
    suspend fun createUser(email: String, username: String, password: String): Long
    suspend fun authorization(email: String, username: String, password: String): Long
    suspend fun getUserById(userId: Long): User
}

class UserRepositoryImpl @Inject constructor(private val userDao: UserDao) : UserRepository {
    override suspend fun createUser(email: String, username: String, password: String): Long {
        val user = User(0, email, username, password)
        return userDao.insert(user)
    }

    override suspend fun authorization(email: String, username: String, password: String): Long {
        return userDao.authenticate(email, username, password)
    }

    override suspend fun getUserById(userId: Long): User {
        return userDao.getUserById(userId)
    }


}