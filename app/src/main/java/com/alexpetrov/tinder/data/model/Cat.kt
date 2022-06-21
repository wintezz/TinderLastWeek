package com.alexpetrov.tinder.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: String,
    val url: String
)