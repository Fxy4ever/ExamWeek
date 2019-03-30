package com.fxy.daymatters.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.dao.DayMatterDao
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
class CommitAffairViewModel(private val dataSource: DayMatterDao) : ViewModel() {


    val isInsertData:MutableLiveData<Long> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<Long>().apply { value = -1 }
    }

    val isDeleteData:MutableLiveData<Int> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<Int>().apply { value = -1 }
    }

    val isUpdateData:MutableLiveData<Int> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<Int>().apply { value = -1 }
    }

    val mAffairs:MutableLiveData<MutableList<Affair>> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MutableList<Affair>>()
    }

    val mClassify:MutableLiveData<MutableList<String>> by lazy(LazyThreadSafetyMode.NONE){
        MutableLiveData<MutableList<String>>()
    }

    fun insertAffair(affair: Affair){
        dataSource.let {dao->
            Observable.create<Long> {
                it.onNext(dao.insertDayMatters(affair))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        isInsertData.value = it
                    }
        }
    }

    fun deleteAffair(affair: Affair){
        dataSource.let {dao->
            Observable.create<Int> {
                it.onNext(dao.deleteDayMatters(affair))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        isDeleteData.value = it
                    }
        }
    }

    fun updateAffair(affair: Affair){
        dataSource.let {dao->
            Observable.create<Int> {
                it.onNext(dao.updateDayMatters(affair))
            }
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        isUpdateData.value = it
                    }
        }
    }

    fun getAffairs(){
        dataSource.let { dao->
            dao.getDayMatters()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        mAffairs.value = it
                    }
        }
    }

    fun getAffairsByClassify(classify:String){
        dataSource.let { dao->
            dao.getDayMattersByKind(classify)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        mAffairs.value = it
                    }
        }
    }

    fun getClassify(){
        dataSource.let {dao->
            dao.getClassify()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe {
                        Log.d("test",it.toString())
                        mClassify.value = it
                    }
        }
    }
}