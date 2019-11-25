package ru.kpfu.itis.android.weather.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.kpfu.itis.android.weather.App
import ru.kpfu.itis.android.weather.R
import ru.kpfu.itis.android.weather.di.weather.component.DaggerWeatherComponent

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerWeatherComponent.builder()
            .appComponent(App.getAppComponents())
            .build()
            .inject(this)
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
        addFragment()
    }

    private fun addFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = WeatherFragment()
        fragmentTransaction.add(R.id.fragment_container, fragment)
        fragmentTransaction.commit()
    }
}
