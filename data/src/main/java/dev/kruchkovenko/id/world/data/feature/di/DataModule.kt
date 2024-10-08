package dev.kruchkovenko.id.world.data.feature.di

import dev.kruchkovenko.id.world.data.feature.client.di.ClientModule
import org.koin.core.module.Module

object DataModule {
    val modules: List<Module> = listOf(ClientModule.clientModule)
}
