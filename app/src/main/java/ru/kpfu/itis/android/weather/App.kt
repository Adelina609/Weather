package ru.kpfu.itis.android.weather

import android.app.Application
import ru.kpfu.itis.android.weather.di.app.component.AppComponent
import ru.kpfu.itis.android.weather.di.app.component.DaggerAppComponent
import ru.kpfu.itis.android.weather.di.app.module.ContextModule
import ru.kpfu.itis.android.weather.di.app.module.DataNetModule
import ru.kpfu.itis.android.weather.di.app.module.LocationModule

class App : Application() {

    override fun onCreate() {
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .dataNetModule(DataNetModule())
            .locationModule(LocationModule())
            .build()
        super.onCreate()
    }

    companion object {
        private var appComponent: AppComponent? = null

        fun getAppComponents(): AppComponent? = appComponent
    }
}
