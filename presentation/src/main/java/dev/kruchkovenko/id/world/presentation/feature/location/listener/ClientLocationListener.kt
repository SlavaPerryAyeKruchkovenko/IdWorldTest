package dev.kruchkovenko.id.world.presentation.feature.location.listener

import android.location.Location
import android.location.LocationListener
import dev.kruchkovenko.id.world.presentation.page.client.ClientViewModel

class ClientLocationListener(private val viewModel: ClientViewModel) : LocationListener {
    override fun onLocationChanged(location: Location) {
        this.viewModel.updateLocation(location)
    }
}
