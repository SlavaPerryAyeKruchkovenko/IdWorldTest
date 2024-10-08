package dev.kruchkovenko.id.world.presentation.di

import dev.kruchkovenko.id.world.presentation.feature.client.di.ClientModule
import dev.kruchkovenko.id.world.presentation.feature.client.di.LocationModule
import org.koin.core.module.Module

object PresentationModule {
    val modules: List<Module> = listOf(
        ClientModule.clientModule,
        ViewModelModule.viewModelModule,
        LocationModule.locationModule
    )
}
