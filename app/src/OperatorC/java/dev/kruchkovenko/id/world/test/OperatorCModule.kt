package dev.kruchkovenko.id.world.test

import android.content.Context
import dev.kruchkovenko.id.world.data.feature.client.model.Client
import dev.kruchkovenko.id.world.test.R
import org.koin.dsl.module

object OperatorCModule {
    val clientModule = module {
        single<Client> {
            Client(name = get<Context>().getString(R.string.operator))
        }
    }
}
