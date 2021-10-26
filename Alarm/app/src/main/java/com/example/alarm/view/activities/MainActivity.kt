package com.example.alarm.view.activities

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarm.R
import com.example.alarm.model.AlarmModel
import com.example.alarm.repository.AlarmSource
import com.example.alarm.view.activities.adapters.AlarmAdapter
import com.example.alarm.view.fragments.AlarmList
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity()/*, AlarmAdapter.ItemInteraction*/ {

    private lateinit var adapterList : AlarmAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu_add_alarm_button.setOnClickListener {
            val intent = Intent(this, NewAlarm::class.java)
            startActivity(intent)
        }

        setFragment()
    }

    private fun setFragment(){
        val alarmListFragment = AlarmList()
        val fragmentManager: FragmentManager  = supportFragmentManager
        val fragmentTransaction : FragmentTransaction  = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.main_frame_layout, alarmListFragment).commit()
    }

    /*override fun onItemInteraction(AlarmId: Int) {
        val intent = Intent(this, NewAlarm::class.java)
        intent.putExtra("AlarmId", AlarmId)
        startActivity(intent)
    }
*/

}














