package ru.kpfu.itis.android.weather.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.kpfu.itis.android.weather.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_main)
    }
}
