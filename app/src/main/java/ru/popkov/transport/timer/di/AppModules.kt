package ru.popkov.transport.timer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.popkov.transport.timer.domain.ServerApi
import ru.popkov.transport.timer.ktor.KtorClient
import ru.popkov.transport.timer.ktor.KtorClientImpl
import ru.popkov.transport.timer.repository.ServerRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Provides
    @Singleton
    fun provideNetwork(client: KtorClient): ServerApi {
        return ServerRepository(client.getKtorClient())
    }

    @Provides
    fun provideKtorClient(): KtorClient {
        return KtorClientImpl()
    }

}