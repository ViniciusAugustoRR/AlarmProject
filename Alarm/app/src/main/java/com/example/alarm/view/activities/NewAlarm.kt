package com.example.alarm.view.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.alarm.R
import com.example.alarm.model.AlarmModel
import com.example.alarm.repository.AlarmSource
import kotlinx.android.synthetic.main.activity_new_alarm.*
import java.sql.Time

class NewAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_alarm)

        var dataAlarm: Time

        val id:Int = intent.getIntExtra("AlarmId", 0)
        val alarmItem: AlarmModel? = AlarmSource.getOneAlarm(id)

        new_alarm_mainTitle.setText(alarmItem?.alarmMainTitle)
        new_alarm_Url.setText(alarmItem?.TuneUrl)
        new_alarm_clock.setOnTimeChangedListener { view, hourOfDay, minute ->
            Log.d("Results -->","$hourOfDay -- $minute")

        }

    }
}