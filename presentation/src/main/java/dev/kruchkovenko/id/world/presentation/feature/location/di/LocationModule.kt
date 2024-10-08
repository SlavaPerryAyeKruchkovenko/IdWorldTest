package dev.kruchkovenko.id.world.presentation.feature.client.di
import android.location.LocationListener
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientName
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientNameImpl
import dev.kruchkovenko.id.world.presentation.feature.location.listener.ClientLocationListener
import org.koin.dsl.module

object LocationModule {
    val locationModule = module {
        single<LocationListener> {
            ClientLocationListener(get())
        }
    }
}
