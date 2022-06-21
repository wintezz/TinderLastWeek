package com.alexpetrov.tinder.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.alexpetrov.tinder.data.db.entity.FavoriteItem

@Database(entities = [FavoriteItem::class],
    version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {
    abstract fun favoriteDao(): Dao
}