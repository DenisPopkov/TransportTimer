package ru.popkov.transport.timer.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "trip_table")
class TripEntity(

    @PrimaryKey(autoGenerate = true) val id: Int,
)