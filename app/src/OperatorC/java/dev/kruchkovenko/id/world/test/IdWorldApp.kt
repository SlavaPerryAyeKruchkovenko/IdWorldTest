package dev.kruchkovenko.id.world.test

import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class IdWorldApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@IdWorldApp)
            modules(AppModules.appModels)
            modules(OperatorCModule.clientModule)
        }
    }
}
