package dev.kruchkovenko.id.world.test

import dev.kruchkovenko.id.world.data.feature.di.DataModule
import dev.kruchkovenko.id.world.presentation.di.PresentationModule
import dev.kruchkovenko.id.world.presentation.di.ViewModelModule
import org.koin.core.module.Module

object AppModules {
    val appModels: List<Module> =
        DataModule.modules + PresentationModule.modules
}

