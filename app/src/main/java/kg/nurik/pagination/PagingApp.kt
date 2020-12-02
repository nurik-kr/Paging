package kg.nurik.pagination

import android.app.Application
import kg.nurik.pagination.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PagingApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PagingApp)
            modules(appModules)
        }
    }

}