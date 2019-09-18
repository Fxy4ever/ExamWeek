package com.fxy.daymatters.dao;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0006\u0010\f\u001a\u00020\tH\'J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/fxy/daymatters/dao/DayMatterDao;", "", "deleteDayMatters", "", "bean", "Lcom/fxy/daymatters/bean/Affair;", "getClassify", "Lio/reactivex/Flowable;", "", "", "getDayMatters", "getDayMattersByKind", "classify", "insertDayMatters", "", "updateDayMatters", "module_day_debug"})
public abstract interface DayMatterDao {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "select * from Affair")
    public abstract io.reactivex.Flowable<java.util.List<com.fxy.daymatters.bean.Affair>> getDayMatters();
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "select * from Affair where classify = :classify")
    public abstract io.reactivex.Flowable<java.util.List<com.fxy.daymatters.bean.Affair>> getDayMattersByKind(@org.jetbrains.annotations.NotNull()
    java.lang.String classify);
    
    @android.arch.persistence.room.Insert()
    public abstract long insertDayMatters(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair bean);
    
    @android.arch.persistence.room.Update()
    public abstract int updateDayMatters(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair bean);
    
    @android.arch.persistence.room.Delete()
    public abstract int deleteDayMatters(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair bean);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "select distinct classify from Affair")
    public abstract io.reactivex.Flowable<java.util.List<java.lang.String>> getClassify();
}