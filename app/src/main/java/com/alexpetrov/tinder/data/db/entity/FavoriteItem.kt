package com.alexpetrov.tinder.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_table",
    indices = [Index(value = arrayOf("id"), unique = true)])
data class FavoriteItem(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "image")
    val image: String,
)