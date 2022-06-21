package com.alexpetrov.tinder.data.db

import androidx.room.Room
import com.alexpetrov.tinder.MainApp

object DataBaseFactory {
    private val dataBase: DataBase by lazy {
        Room.databaseBuilder(MainApp.ContextHolder.context,
            DataBase::class.java, "favorite.db")
            .build()
    }

    fun create(): DataBase = dataBase
}