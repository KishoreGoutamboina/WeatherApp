package com.example.weatherapplication.Worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.ForegroundInfo
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.weatherapplication.R
import javax.inject.Inject

class NotificationWorker @Inject constructor(
    val context: Context,
    workerParams: WorkerParameters
): Worker(context,workerParams){

    var notificationManager:NotificationManager?=null
    val CHANNEL_ID = "weather"
    val NOTIFICATION_ID=106
    val CHANNEL_NAME = "content"
    val CHANNEL_DESCRIPTION = "weather notification"

    init {
      notificationManager=  context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    }

    override fun doWork(): Result {

        setForegroundAsync(createForegroundNotification())

        return Result.success()
    }

    fun createForegroundNotification(): ForegroundInfo{
           notificationChannel()
        val notification= NotificationCompat.Builder(context,CHANNEL_ID)
            .setContentTitle("Weather Forecast")
            .setContentText("Click weather information")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        return ForegroundInfo(NOTIFICATION_ID,notification)
    }

    private fun notificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel= NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT).apply {
                description=CHANNEL_DESCRIPTION
            }
           notificationManager?.createNotificationChannel(channel)
        }
    }
}