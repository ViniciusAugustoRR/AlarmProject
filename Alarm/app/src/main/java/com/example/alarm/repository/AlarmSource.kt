package com.example.alarm.repository

import com.example.alarm.model.AlarmModel

object AlarmSource {

    private var AlarmList : ArrayList<AlarmModel>
    init {
        AlarmList = GetAlarmList()
    }

    fun GetAlarmList() : ArrayList<AlarmModel>{
        val alarmList = ArrayList<AlarmModel>()
        alarmList.add(AlarmModel(1, "Alarme1", "Tempo Restante 1", "Url_1"))
        alarmList.add(AlarmModel(2, "Alarme2", "Tempo Restante 2", "Url_2"))
        alarmList.add(AlarmModel(3, "Alarme3", "Tempo Restante 3", "Url_3"))
        alarmList.add(AlarmModel(4, "Alarme4", "Tempo Restante 4", "Url_4"))
        alarmList.add(AlarmModel(5, "Alarme5", "Tempo Restante 5", "Url_5"))
        alarmList.add(AlarmModel(6, "Alarme6", "Tempo Restante 6", "Url_6"))
        alarmList.add(AlarmModel(7, "Alarme7", "Tempo Restante 7", "Url_7"))

        return alarmList
    }
    fun ReturnAlarmList() = AlarmList

    fun getOneAlarm(AlarmId : Int) : AlarmModel? {
        return AlarmList.find { it.alarmId == AlarmId }
    }


}