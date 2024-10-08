package dev.kruchkovenko.id.world.presentation.feature.location.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import androidx.core.app.ActivityCompat

internal object PermissionUtil {
    fun checkGeolocationPermission(context: Context) = ActivityCompat.checkSelfPermission(
        context, Manifest.permission.ACCESS_COARSE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
        context, Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    fun isLocationEnabled(manager: LocationManager): Boolean {
        return manager.isProviderEnabled(LocationManager.GPS_PROVIDER) || manager.isProviderEnabled(
            LocationManager.NETWORK_PROVIDER
        )
    }

    fun getLocationManager(context: Context) =
        context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
}
