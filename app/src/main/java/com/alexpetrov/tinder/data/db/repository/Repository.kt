package com.alexpetrov.tinder.data.db.repository

import com.alexpetrov.tinder.data.dto.ImageResponce
import com.alexpetrov.tinder.data.model.Cat

interface Repository {
    suspend fun getDataFromDB(): List<Cat>
    suspend fun insertDataToDB(imageResponse: ImageResponce)
}