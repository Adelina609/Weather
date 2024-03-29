package ru.kpfu.itis.android.weather.model

import com.google.gson.annotations.SerializedName

data class Details (

	@SerializedName("id") val id : Int,
	@SerializedName("main") val main : String,
	@SerializedName("description") val description : String,
	@SerializedName("icon") val icon : String
)
