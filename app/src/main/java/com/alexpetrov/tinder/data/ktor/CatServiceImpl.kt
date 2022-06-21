package com.alexpetrov.tinder.data.ktor

import com.alexpetrov.tinder.data.dto.ImageResponce
import com.alexpetrov.tinder.data.dto.MessageResponce
import com.alexpetrov.tinder.data.dto.VoteRequest
import com.alexpetrov.tinder.data.dto.VoteResponce
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class CatServiceImpl(
    private val client: HttpClient
) : CatService {
    override suspend fun getRandomImage(): List<ImageResponce> {
        return client.get {
            url(Resource.imageUrl)
        }
    }

    override suspend fun getImageById(id: String): ImageResponce {
        val url = "$baseUrl$id?$apiKey"
        return client.get {
            url(url)
        }
    }

    override suspend fun getCatList(): List<VoteResponce> {
        return client.get {
            url(Resource.catUrl)
        }
    }

    override suspend fun createVote(postRequest: VoteRequest): MessageResponce {
        return client.post {
            url(Resource.catUrl)
            contentType(ContentType.Application.Json)
            body = postRequest
        }
    }

    companion object {
        private const val baseUrl = "https://api.thecatapi.com/v1/images/"
        private const val apiKey = "api_key=b9940f18-3124-4b46-bb7d-2f03a64e11e2"
    }
}