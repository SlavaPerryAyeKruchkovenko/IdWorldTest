package dev.kruchkovenko.id.world.presentation.feature.client.di
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientName
import dev.kruchkovenko.id.world.domain.feature.client.useCase.GetClientNameImpl
import org.koin.dsl.module

object ClientModule {
    val clientModule = module {
        single<GetClientName> {
            GetClientNameImpl(repository = get())
        }
    }
}
