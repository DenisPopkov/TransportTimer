package ru.popkov.transport.timer.room.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.popkov.transport.timer.room.entities.TripEntity

@Dao
interface TripDAO {

    @Query("SELECT * FROM trip_table ORDER BY id ASC")
    fun getTrips(): Flow<List<TripEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTrip(trip: TripEntity)

    @Query("DELETE FROM trip_table")
    suspend fun deleteAllTrips()
}