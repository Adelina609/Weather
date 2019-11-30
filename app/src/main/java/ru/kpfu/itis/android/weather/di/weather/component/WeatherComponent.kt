package ru.kpfu.itis.android.weather.di.weather.component

import dagger.Component
import ru.kpfu.itis.android.weather.di.app.component.AppComponent
import ru.kpfu.itis.android.weather.di.weather.module.InteractorModule
import ru.kpfu.itis.android.weather.di.weather.module.PresenterModule
import ru.kpfu.itis.android.weather.di.weather.scope.WeatherScope
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
