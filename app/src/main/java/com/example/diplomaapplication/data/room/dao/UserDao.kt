package com.example.diplomaapplication.data.room.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.diplomaapplication.data.room.entities.User

@Dao
abstract class UserDao : BaseDao<User>() {

    @Query("SELECT EXISTS(SELECT * FROM users WHERE (username = :username OR email = :email) AND password = :password)")
    abstract fun authenticate(username: String?, email: String?, password: String): Boolean
}