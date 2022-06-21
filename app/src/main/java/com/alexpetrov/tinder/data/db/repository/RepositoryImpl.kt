package com.alexpetrov.tinder.data.db.repository

import com.alexpetrov.tinder.data.db.DataBaseFactory
import com.alexpetrov.tinder.data.dto.ImageResponce
import com.alexpetrov.tinder.data.model.Cat
import com.alexpetrov.tinder.presentation.utils.mapFavorite
import com.alexpetrov.tinder.presentation.utils.mapImage

class RepositoryImpl : Repository {

    private val db = DataBaseFactory.create().favoriteDao()

    override suspend fun getDataFromDB(): List<Cat> {
        return mapFavorite(db.getFavoriteList())
    }

    override suspend fun insertDataToDB(imageResponse: ImageResponce) {
        db.insert(mapImage(imageResponse))
    }
}