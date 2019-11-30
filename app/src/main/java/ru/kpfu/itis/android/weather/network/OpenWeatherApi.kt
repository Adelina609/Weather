package ru.kpfu.itis.android.weather.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.kpfu.itis.android.weather.model.Weather

interface OpenWeatherApi {

    @GET("weather")
    fun getWeatherData(@Query("lat") lat : Double,
                       @Query("lon") lon : Double,
                       @Query("appid") appid : String,
                       @Query("units") units : String) : Single<Weather>
}
