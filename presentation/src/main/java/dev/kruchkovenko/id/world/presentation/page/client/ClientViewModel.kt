package dev.kruchkovenko.id.world.presentation.page.client

import android.location.Location
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientName

class ClientViewModel(private val getClientName: GetClientName) : ViewModel() {
    private val _location = MutableLiveData<Location>()
    val location get() = _location

    fun clientName() = getClientName()
    fun updateLocation(location: Location) {
        _location.postValue(location)
    }
}
