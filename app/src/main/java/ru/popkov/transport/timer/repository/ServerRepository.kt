package ru.popkov.transport.timer.repository

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ru.popkov.transport.timer.domain.ServerApi

class ServerRepository(private val client: HttpClient) : ServerApi {

    override suspend fun postTrip(trip: String) {
        client.post("http://10.0.2.2:8087/trip") {
            contentType(ContentType.Application.Json)
            setBody("trip name")
        }
    }
}