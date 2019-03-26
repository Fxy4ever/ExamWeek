package com.fxy.daymatters.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Room
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.db.DayMatterDatabase
import com.fxy.lib.BaseApp
import com.fxy.lib.utils.extensions.setSchedulers

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
class CommitAffairViewModel : ViewModel() {

    val db: DayMatterDatabase? by lazy(mode = LazyThreadSafetyMode.NONE){
        Room.databaseBuilder(BaseApp.context,
                DayMatterDatabase::class.java,
                "DayMatter"
        ).build()
    }

    private val affairs = MutableLiveData<MutableList<Affair>>()
    val isInsertData:MutableLiveData<Long> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<Long>().apply { value = -1 }
    }


    val mAffairs:MutableLiveData<MutableList<Affair>> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MutableList<Affair>>()
    }

    fun insertAffair(affair: Affair){
        db?.let {database->
            isInsertData.value = database.dayMattersDao().insertDayMatters(affair)
        }
    }

    fun getAffairs(){
        db?.let {database->
            database.dayMattersDao()
                    .getDayMatters()
                    .setSchedulers()
                    .subscribe {
                        mAffairs.value = it
                    }
        }
    }
}