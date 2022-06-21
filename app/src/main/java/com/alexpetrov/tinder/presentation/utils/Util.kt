package com.alexpetrov.tinder.presentation.utils

import com.alexpetrov.tinder.data.db.entity.FavoriteItem
import com.alexpetrov.tinder.data.dto.ImageResponce
import com.alexpetrov.tinder.data.model.Cat

fun mapImage(imageResponse: ImageResponce): FavoriteItem {
    return FavoriteItem(
        imageResponse.id,
        imageResponse.url,
    )
}

fun mapFavorite(favoriteItemList: List<FavoriteItem>): List<Cat> {
    return favoriteItemList.map {
        Cat(it.id, it.image)
    }
}