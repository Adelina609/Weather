package ru.kpfu.itis.android.weather.di.weather.component

import android.content.Context
import com.google.android.gms.location.FusedLocationProviderClient
import dagger.Component
import ru.kpfu.itis.android.weather.di.app.component.AppComponent
import ru.kpfu.itis.android.weather.di.app.module.ContextModule
import ru.kpfu.itis.android.weather.di.app.module.DataNetModule
import ru.kpfu.itis.android.weather.di.app.scope.ApplicationScope
import ru.kpfu.itis.android.weather.di.weather.module.InteractorModule
import ru.kpfu.itis.android.weather.di.weather.module.PresenterModule
import ru.kpfu.itis.android.weather.di.weather.scope.WeatherScope
import ru.kpfu.itis.android.weather.interactor.WeatherInteractor
import ru.kpfu.itis.android.weather.network.OpenWeatherApi
import ru.kpfu.itis.android.weather.presenter.WeatherPresenter
import ru.kpfu.itis.android.weather.ui.MainActivity
import ru.kpfu.itis.android.weather.ui.WeatherFragment

@WeatherScope
@Component( dependencies = [AppComponent::class],
    modules = [InteractorModule::class, PresenterModule::class]
)
interface WeatherComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(weatherFragment: WeatherFragment)
}
