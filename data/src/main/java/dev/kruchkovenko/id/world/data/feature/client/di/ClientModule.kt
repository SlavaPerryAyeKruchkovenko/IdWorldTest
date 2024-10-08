package dev.kruchkovenko.id.world.data.feature.client.di

import dev.kruchkovenko.id.world.data.feature.client.repository.ClientRepositoryImpl
import dev.kruchkovenko.id.world.domain.feature.client.repository.ClientRepository
import org.koin.dsl.module

object ClientModule {
    val clientModule = module {
        single<ClientRepository> {
            ClientRepositoryImpl(client = get())
        }
    }
}
