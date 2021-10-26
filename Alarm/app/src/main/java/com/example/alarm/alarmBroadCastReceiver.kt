package com.example.alarm

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmBroadCastReceiver: BroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.alarm.alarmmanager")){
            val message = intent.getStringExtra("message")
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }

    }
}