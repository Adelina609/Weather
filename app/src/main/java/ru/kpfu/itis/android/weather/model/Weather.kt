package ru.kpfu.itis.android.weather.model

import com.google.gson.annotations.SerializedName

data class Weather (

	@SerializedName("coord") val coord : Coord,
	@SerializedName("weather") val details : List<Details>,
	@SerializedName("base") val base : String,
	@SerializedName("main") val main : Main,
	@SerializedName("visibility") val visibility : Int,
	@SerializedName("wind") val wind : Wind,
	@SerializedName("clouds") val clouds : Clouds,
	@SerializedName("dt") val dt : Int,
	@SerializedName("sys") val sys : Sys,
	@SerializedName("timezone") val timezone : Int,
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("cod") val cod : Int
)