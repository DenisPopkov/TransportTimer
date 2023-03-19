package ru.popkov.transport.timer.room.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import ru.popkov.transport.timer.room.daos.TripDAO
import ru.popkov.transport.timer.room.entities.TripEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TripRepository @Inject constructor(private val tripDao: TripDAO) {

    val allWords: Flow<List<TripEntity>> = tripDao.getTrips()

    @WorkerThread
    suspend fun insert(trip: TripEntity) {
        tripDao.addTrip(trip)
    }
}