package ru.popkov.transport.timer.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import ru.popkov.transport.timer.domain.ServerApi
import ru.popkov.transport.timer.room.repository.TripRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val serverApi: ServerApi,
    private val tripRepository: TripRepository
) : ViewModel() {

    fun postTrip(tripName: String) {
        viewModelScope.launch {
            serverApi.postTrip(tripName)
        }
    }
}