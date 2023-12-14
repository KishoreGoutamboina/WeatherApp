package com.example.weatherapplication

import android.app.Application
import androidx.work.*
import com.example.weatherapplication.Worker.NotificationWorker
import dagger.hilt.android.HiltAndroidApp
import java.util.concurrent.TimeUnit

@HiltAndroidApp
class WeatherAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Set up WorkManager to periodically refresh data in the background
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()

        val periodicWorkRequest =
            PeriodicWorkRequest.Builder(NotificationWorker::class.java, 15, TimeUnit.MINUTES)
                .setConstraints(constraints)
                .build()
        var workManager:WorkManager=   WorkManager.getInstance(this)

         workManager.enqueueUniquePeriodicWork(
            "WeatherWorker",
            ExistingPeriodicWorkPolicy.REPLACE,
            periodicWorkRequest
        )

    }
}