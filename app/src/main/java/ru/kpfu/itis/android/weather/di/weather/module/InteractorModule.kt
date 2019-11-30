package ru.kpfu.itis.android.weather.di.weather.module

import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.android.weather.di.weather.scope.WeatherScope
import ru.kpfu.itis.android.weather.interactor.WeatherInteractor
import ru.kpfu.itis.android.weather.network.OpenWeatherApi

@Module
class InteractorModule {

    @Provides
    @WeatherScope
    fun provideWeatherIntercator(
        weatherApi: OpenWeatherApi,
        client: FusedLocationProviderClient
    ): WeatherInteractor =
        WeatherInteractor(weatherApi, client)
}
