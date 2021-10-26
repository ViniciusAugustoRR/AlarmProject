package com.example.alarm.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.alarm.R
import com.example.alarm.model.AlarmModel
import com.example.alarm.repository.AlarmSource
import com.example.alarm.repository.SendEvent
import kotlinx.android.synthetic.main.activity_new_alarm.*
import java.text.SimpleDateFormat
import java.util.*

class NewAlarm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_alarm)

        if(intent.extras != null){
            setAlarmFields()
        }

        new_alarm_save_alarm.setOnClickListener{
            val hour: Int = new_alarm_clock.hour
            val minute: Int = new_alarm_clock.minute
            Log.d("NewAlarm", "---> $hour : $minute")

            val alarm = SendEvent(this)
            alarm.SetAlarm(hour, minute)

        }

    }


    private fun setAlarmFields(){
        val id:Int = intent.getIntExtra("AlarmId", 0)
        val alarmItem: AlarmModel? = AlarmSource.getOneAlarm(id)
        new_alarm_mainTitle.setText(alarmItem?.alarmMainTitle)
        new_alarm_Url.setText(alarmItem?.TuneUrl)
    }
}