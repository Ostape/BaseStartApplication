package com.robosh.basestartapplication.receiver

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.os.Build
import android.provider.Settings.Global.getString
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.navigation.NavDeepLinkBuilder
import com.robosh.basestartapplication.BrowseActivity
import com.robosh.basestartapplication.R


// TODO BTW: replace constants in xml

class AlarmNotificationReceiver : BroadcastReceiver() {

    companion object {
        const val CHANNEL_ID= "CHANNEL_ID";
    }
    override fun onReceive(context: Context, intent: Intent) {
        // todo add notification channel
        Log.d("TAGEERRR", "AlarmNotificationReceiver")

        showNotification(context)
    }

    private fun showNotification(context: Context) {

        val pendingIntent = NavDeepLinkBuilder(context)
            .setComponentName(BrowseActivity::class.java)
            .setGraph(R.navigation.navigation_graph)
            .setDestination(R.id.detailsBookNoteFragment)
//            .setArguments(bundle)
            .createPendingIntent()


        val builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("My notification")
            .setContentText("Hello World!")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            // Set the intent that will fire when the user taps the notification
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the NotificationChannel
            val name = "Notification Channel"
            val descriptionText = "etString(R.string.channel_description)"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val mChannel = NotificationChannel(CHANNEL_ID, name, importance)
            mChannel.description = descriptionText
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = context.getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(mChannel)
        }

        with(NotificationManagerCompat.from(context)) {
            // notificationId is a unique int for each notification that you must define
            notify(1, builder.build())
        }
    }
}