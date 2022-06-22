package com.example.roomDB.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @ColumnInfo var username: String?,
    @ColumnInfo var password: String?
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
