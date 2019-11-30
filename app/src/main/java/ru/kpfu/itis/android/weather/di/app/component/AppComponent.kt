package ru.kpfu.itis.android.weather.di.app.component

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Component
import ru.kpfu.itis.android.weather.di.app.module.ContextModule
import ru.kpfu.itis.android.weather.di.app.module.DataNetModule
import ru.kpfu.itis.android.weather.di.app.module.LocationModule
import ru.kpfu.itis.android.weather.di.app.scope.ApplicationScope
import ru.kpfu.itis.android.weather.network.OpenWeatherApi

@ApplicationScope
@Component(
    modules = [ContextModule::class, DataNetModule::class, LocationModule::class]
)
interface AppComponent {
    fun provideApp(): Context
    fun provideWeatherApi(): OpenWeatherApi
    fun provideFusedClient(): FusedLocationProviderClient
}
