package com.fxy.daymatters.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.persistence.room.Room
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.db.DayMatterDatabase
import com.fxy.daymatters.debug.TestApplication
import com.fxy.lib.BaseApp
import com.fxy.lib.utils.extensions.setSchedulers
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
class CommitAffairViewModel : ViewModel() {

    val db: DayMatterDatabase? by lazy(mode = LazyThreadSafetyMode.NONE){
        Room.databaseBuilder(TestApplication.context,
                DayMatterDatabase::class.java,
                "DayMatter.db"
        ).build()
    }

    val isInsertData:MutableLiveData<Long> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<Long>().apply { value = -1 }
    }


    val mAffairs:MutableLiveData<MutableList<Affair>> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MutableList<Affair>>()
    }

    fun insertAffair(affair: Affair){
        db?.let {database->
            Observable.create<Long> {
                it.onNext(database.dayMattersDao().insertDayMatters(affair))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        isInsertData.value = it
                    }
        }
    }

    fun getAffairs(){
        db?.let {database->
            database.dayMattersDao()
                    .getDayMatters()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        mAffairs.value = it
                    }
        }
    }
}