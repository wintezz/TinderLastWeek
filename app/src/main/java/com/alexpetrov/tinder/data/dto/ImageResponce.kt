package com.alexpetrov.tinder.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ImageResponce(
    val id: String,
    val url: String,
)