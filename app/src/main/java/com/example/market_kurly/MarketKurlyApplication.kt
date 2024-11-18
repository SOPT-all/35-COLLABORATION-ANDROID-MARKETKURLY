package com.example.market_kurly

import android.app.Application
import timber.log.Timber

class MarketKurlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setTimber()
    }

    private fun setTimber() {
        Timber.plant(Timber.DebugTree())
    }
}