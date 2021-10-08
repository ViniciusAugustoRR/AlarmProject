package com.example.alarm.view.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarm.R
import com.example.alarm.model.AlarmModel
import com.example.alarm.repository.AlarmSource
import com.example.alarm.view.activities.adapters.AlarmAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), AlarmAdapter.ItemInteraction {

    private lateinit var adapterList : AlarmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapterList = AlarmAdapter(this)
        adapterList.setAlarmList(AlarmSource.ReturnAlarmList())

        menu_alarm_recycle.apply{
            layoutManager = LinearLayoutManager(context!!)
            adapter = adapterList
            setHasFixedSize(true)
        }

    }

    override fun onItemInteraction(AlarmId: Int) {
        val intent = Intent(this, NewAlarm::class.java)
        intent.putExtra("AlarmId", AlarmId)
        startActivity(intent)
    }


}