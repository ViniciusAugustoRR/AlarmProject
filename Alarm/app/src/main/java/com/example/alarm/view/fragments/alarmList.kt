package com.example.alarm.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.alarm.R
import com.example.alarm.repository.AlarmSource
import com.example.alarm.view.activities.NewAlarm
import com.example.alarm.view.activities.adapters.AlarmAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_alarm_list.*



class AlarmList : Fragment(), AlarmAdapter.ItemInteraction {
    private lateinit var adapterList : AlarmAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitiateList()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_alarm_list, container, false)
    }


    private fun setInitiateList(){
        try {
            adapterList = AlarmAdapter(this)
            adapterList.setAlarmList(AlarmSource.ReturnAlarmList())

            frag_alarm_recycle.apply {
                layoutManager = LinearLayoutManager(this.context!!)
                adapter = adapterList
                setHasFixedSize(true)
            }
        } catch (E : Exception){
            Toast.makeText(context, "Erro : $E", Toast.LENGTH_LONG ).show()
        }

    }

    override fun onItemInteraction(AlarmId: Int) {
        try {

            val intent = Intent(this.context, NewAlarm::class.java)
            intent.putExtra("AlarmId", AlarmId)
            startActivity(intent)
        } catch (E : Exception){
            Toast.makeText(context, "Erro : $E", Toast.LENGTH_LONG ).show()
        }
    }
}