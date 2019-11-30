package ru.kpfu.itis.android.weather.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.kpfu.itis.android.weather.model.Weather

@StateStrategyType(value = AddToEndSingleStrategy::class)
interface WeatherView : MvpView {
    fun displayWeather(weather: Weather)
    fun displayError(error: Throwable)
    fun checkLocationPermissions()
    fun displayNeedPermissionsError()
    fun showProgressBar()
    fun hideProgressBar()
}
