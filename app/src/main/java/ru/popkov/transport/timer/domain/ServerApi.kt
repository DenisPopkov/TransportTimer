package ru.popkov.transport.timer.domain

interface ServerApi {
    suspend fun postTrip(trip: String)
}