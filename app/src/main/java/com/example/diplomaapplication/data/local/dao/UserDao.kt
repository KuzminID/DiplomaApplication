package com.example.diplomaapplication.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.diplomaapplication.data.local.entities.User

@Dao
interface UserDao : BaseDao<User> {

    @Query("SELECT EXISTS(SELECT * FROM users WHERE (username = :username OR email = :email) AND password = :password)")
    fun authenticate(username: String?, email: String?, password: String): Long

    @Query("SELECT * FROM users WHERE(id = :userId)")
    fun getUserById(userId: Long): User
}