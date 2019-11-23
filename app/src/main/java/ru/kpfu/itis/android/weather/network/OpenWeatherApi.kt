package ru.kpfu.itis.android.weather.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherApi {

    //TODO()
    @GET
    fun getWeatherData(@Query("lat") lat : Long, @Query("lon") lon : Long) : Single<>

}