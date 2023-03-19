package ru.popkov.transport.timer.room

import androidx.room.Database
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope
import ru.popkov.transport.timer.di.ApplicationScope
import ru.popkov.transport.timer.room.daos.TripDAO
import ru.popkov.transport.timer.room.entities.TripEntity
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [TripEntity::class], version = 1, exportSchema = false)
abstract class TripRoomDatabase : RoomDatabase() {

    abstract fun tripDao(): TripDAO

    class Callback @Inject constructor(
        private val database: Provider<TripRoomDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback()
}