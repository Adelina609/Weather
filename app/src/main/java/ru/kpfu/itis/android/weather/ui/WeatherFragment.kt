package ru.kpfu.itis.android.weather.ui

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.google.android.gms.common.api.ResolvableApiException
import com.google.android.gms.location.*
import com.google.android.gms.tasks.Task
import kotlinx.android.synthetic.main.fragment_main.*
import ru.kpfu.itis.android.weather.App
import ru.kpfu.itis.android.weather.R
import ru.kpfu.itis.android.weather.di.weather.component.DaggerWeatherComponent
import ru.kpfu.itis.android.weather.di.weather.module.InteractorModule
import ru.kpfu.itis.android.weather.di.weather.module.PresenterModule
import ru.kpfu.itis.android.weather.model.Weather
import ru.kpfu.itis.android.weather.presenter.WeatherPresenter
import javax.inject.Inject

class WeatherFragment : MvpAppCompatFragment(), WeatherView {

    @Inject
    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    @ProvidePresenter
    fun getPresenter(): WeatherPresenter = weatherPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerWeatherComponent.builder()
            .appComponent(App.getAppComponents())
            .interactorModule(InteractorModule())
            .presenterModule(PresenterModule())
            .build()
            .inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_CODE && permissions[0] == LOCATION_PERMISSION
            && grantResults[0] == PackageManager.PERMISSION_GRANTED
        ) {
            weatherPresenter.onLocationPermissionsGranted()
        } else {
            weatherPresenter.onLocationPermissionsDenied()
        }
    }

    override fun displayWeather(weather: Weather) {
        tv_city_name.text = weather.name
        tv_humidity_value.text = "${weather.main.humidity}"
        tv_pressure_value.text = "${weather.main.pressure}"
        tv_max_temp_value.text = "${weather.main.temp_max.toInt()}°"
        tv_min_temp_value.text = "${weather.main.temp_min.toInt()}°"
        tv_temp.text = "${weather.main.temp.toInt()}°C"
        tv_wind_value.text = "${weather.wind.speed}"
        val icon = weather.details[0].icon
        Glide.with(this)
            .load("http://openweathermap.org/img/wn/${icon}@2x.png")
            .into(iv_weather_now)
    }

    override fun displayError(error: Throwable) {
        Toast.makeText(
            context,
            "${getString(R.string.error)} by ${error.message}",
            Toast.LENGTH_LONG
        ).show()
    }

    override fun displayNeedPermissionsError() {
        Toast.makeText(
            context,
            getString(R.string.error_permissions),
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun showProgressBar() {
        main_progressBar.visibility = ProgressBar.VISIBLE
    }

    override fun hideProgressBar() {
        main_progressBar.visibility = ProgressBar.INVISIBLE
    }

    override fun checkLocationPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            context?.let { context ->
                if (ContextCompat.checkSelfPermission(context, LOCATION_PERMISSION) !=
                    PackageManager.PERMISSION_GRANTED
                ) {
                    requestPermissions(
                        arrayOf(LOCATION_PERMISSION),
                        PERMISSION_REQUEST_CODE
                    )
                } else {

                    weatherPresenter.onLocationPermissionsGranted()
                }
            }
        } else {
            weatherPresenter.onLocationPermissionsGranted()
        }
    }

    companion object {
        private const val LOCATION_PERMISSION = Manifest.permission.ACCESS_COARSE_LOCATION
        private const val PERMISSION_REQUEST_CODE = 324
    }
}
