package ru.kpfu.itis.android.weather.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import ru.kpfu.itis.android.weather.interactor.WeatherInteractor
import ru.kpfu.itis.android.weather.ui.WeatherView

@InjectViewState
class WeatherPresenter(
    private val weatherInteractor: WeatherInteractor
) : MvpPresenter<WeatherView>() {

    private val disposables = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.checkLocationPermissions()
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.dispose()
    }

    fun onLocationPermissionsDenied() {
//        viewState.displayNeedPermissionsError()
    }

    fun onLocationPermissionsGranted() {
        getWeather()
    }

    fun getWeather() {
        disposables += weatherInteractor.getGeoPosition()
            .subscribeBy(onSuccess = {
                getWeatherByLatLon(it.latitude, it.longitude)
            }, onError = {
                viewState.displayError(it)
            })
    }

    private fun getWeatherByLatLon(lat: Double, lon: Double) {
        disposables += weatherInteractor.getWeather(lat, lon)
            .subscribeBy(onSuccess = {
                viewState.displayWeather(it)
            }, onError = {
                viewState.displayError(it)
            })
    }
}
