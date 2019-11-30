package ru.kpfu.itis.android.weather.interactor

import android.location.Location
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.kpfu.itis.android.weather.model.Weather
import ru.kpfu.itis.android.weather.network.OpenWeatherApi

class WeatherInteractor(
    private val weatherApi: OpenWeatherApi,
    private val fusedLocationClient: FusedLocationProviderClient
) {

    fun getWeather(lat: Double, lon: Double, appid: String, units: String): Single<Weather> =
        weatherApi.getWeatherData(lat, lon, appid, units)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getGeoPosition(): Single<Location> =
        Single.create<Location> { emitter ->
            fusedLocationClient.lastLocation.addOnSuccessListener {
                emitter.onSuccess(it)
            }.addOnFailureListener {
                emitter.onError(it)
            }
        }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}
