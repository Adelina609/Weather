package ru.kpfu.itis.android.weather.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kpfu.itis.android.weather.model.Weather

interface OpenWeatherApi {

    @GET
    fun getWeatherData(@Query("lat") lat : Double, @Query("lon") lon : Double) : Single<Weather>
}
