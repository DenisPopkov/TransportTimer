package ru.popkov.transport.timer.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ru.popkov.transport.timer.room.TripRoomDatabase
import ru.popkov.transport.timer.room.daos.TripDAO
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: TripRoomDatabase.Callback): TripRoomDatabase {
        return Room.databaseBuilder(application, TripRoomDatabase::class.java, "trip_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }

    @Provides
    fun provideTripDao(db: TripRoomDatabase): TripDAO {
        return db.tripDao()
    }
}