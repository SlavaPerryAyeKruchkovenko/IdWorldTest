package dev.kruchkovenko.id.world.presentation.di

import dev.kruchkovenko.id.world.presentation.page.client.ClientViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val viewModelModule = module {
        single {
            ClientViewModel(get())
        }
    }
}
