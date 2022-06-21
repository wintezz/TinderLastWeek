package com.alexpetrov.tinder.presentation.utils

import com.alexpetrov.tinder.data.model.Cat
import com.alexpetrov.tinder.data.dto.ImageResponce

sealed class AppState {
    data class SuccessMain(val imageResponse: List<ImageResponce>) : AppState()
    data class SuccessFavorite(val favoriteData: List<Cat>) : AppState()
    data class Error(val e: Throwable) : AppState()
}