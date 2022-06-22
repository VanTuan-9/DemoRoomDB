package com.example.roomDB.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.roomDB.entity.User

@Dao
interface UserDao {
    @Query("select * from user")
    fun getAllUser(): List<User>

    @Insert
    fun insertUser(user: User)

    @Query("delete from user where id = :id")
    fun deleteUser(id: Int)
}