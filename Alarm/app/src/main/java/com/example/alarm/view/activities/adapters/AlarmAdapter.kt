package com.example.alarm.view.activities.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.alarm.R
import com.example.alarm.model.AlarmModel
import com.example.alarm.view.activities.NewAlarm
import kotlinx.android.synthetic.main.card_alarm.view.*

class AlarmAdapter(private val interaction: ItemInteraction? = null) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    lateinit var Alarms : ArrayList<AlarmModel>

    fun setAlarmList(newAlarmList : ArrayList<AlarmModel>){
        Alarms = newAlarmList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return AlarmRecyclerVH(
            LayoutInflater.from(parent.context).inflate(
                R.layout.card_alarm,
                parent,
                false
            ),
            interaction
        )
    }
    override fun getItemCount(): Int {
        return Alarms.size
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is AlarmRecyclerVH -> {
                holder.bind(Alarms[position], position)
            }
        }
    }
    class AlarmRecyclerVH
    constructor(
        itemView: View,
        private val interaction: ItemInteraction?
    ) : RecyclerView.ViewHolder(itemView){

        fun bind(item: AlarmModel, position: Int) = with(itemView){

            itemView.setOnClickListener {
                interaction?.onItemInteraction(item.alarmId)
            }

            card_alarm_maintitle.text = item.alarmMainTitle
            card_alarm_subtitle.text = item.alarmSubTitle
        }

    }

    interface ItemInteraction{
        fun onItemInteraction(AlarmId: Int)
    }

}