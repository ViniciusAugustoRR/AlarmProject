package com.example.alarm.repository

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.alarm.AlarmBroadCastReceiver
import java.util.*

class SendEvent(context: Context) {

    private var currentContext: Context? = context

    fun SetAlarm (hour: Int, minute: Int){

        try {
            val calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            calendar.set(Calendar.SECOND, 0)

            val alarmManager = currentContext!!.getSystemService(Context.ALARM_SERVICE) as AlarmManager
            val intent = Intent(currentContext, AlarmBroadCastReceiver::class.java)
            intent.putExtra("message", "ALARM")
            intent.action = "com.alarm.alarmmanager"
            val pendingIntent = PendingIntent.getBroadcast(currentContext, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, AlarmManager.INTERVAL_DAY, pendingIntent)
            Toast.makeText(currentContext, "SEND EVENT", Toast.LENGTH_LONG ).show()


        } catch (E: Exception){
            Toast.makeText(currentContext, "Erro : $E", Toast.LENGTH_LONG ).show()
        }
    }

}