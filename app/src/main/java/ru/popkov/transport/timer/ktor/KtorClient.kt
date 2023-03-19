package ru.popkov.transport.timer.ktor

import io.ktor.client.HttpClient

interface KtorClient {
    fun getKtorClient(): HttpClient
}