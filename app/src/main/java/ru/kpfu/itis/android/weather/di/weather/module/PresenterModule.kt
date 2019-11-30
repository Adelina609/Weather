package ru.kpfu.itis.android.weather.di.weather.module

import dagger.Module
import dagger.Provides
import ru.kpfu.itis.android.weather.di.weather.scope.WeatherScope
import ru.kpfu.itis.android.weather.interactor.WeatherInteractor
import ru.kpfu.itis.android.weather.presenter.WeatherPresenter

@Module
class PresenterModule {

    @Provides
    @WeatherScope
    fun provideWeatherPresenter(
        weatherInteractor: WeatherInteractor
    ): WeatherPresenter =
        WeatherPresenter(weatherInteractor)
}
