package ru.kpfu.itis.android.weather.di.app.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import ru.kpfu.itis.android.weather.di.app.scope.ApplicationScope

@Module
class ContextModule(private val app: Application) {
    @Provides
    @ApplicationScope
    fun provideContext(): Context = app.applicationContext
}