package com.alexpetrov.tinder.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class VoteResponce(
    val image_id: String,
    val created_at: String,
    val value: Int
)