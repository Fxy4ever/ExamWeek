package com.fxy.daymatters.viewmodel;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/3/26
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\u0006\u0010\u001c\u001a\u00020\u001aJ\u000e\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0016J\u0006\u0010\u001f\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012J\u000e\u0010!\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\bR!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000b\u0010\bR!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\bR\'\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0013\u0010\bR\'\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00110\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\b\u00a8\u0006\""}, d2 = {"Lcom/fxy/daymatters/viewmodel/CommitAffairViewModel;", "Landroid/arch/lifecycle/ViewModel;", "dataSource", "Lcom/fxy/daymatters/dao/DayMatterDao;", "(Lcom/fxy/daymatters/dao/DayMatterDao;)V", "isDeleteData", "Landroid/arch/lifecycle/MutableLiveData;", "", "()Landroid/arch/lifecycle/MutableLiveData;", "isDeleteData$delegate", "Lkotlin/Lazy;", "isInsertData", "", "isInsertData$delegate", "isUpdateData", "isUpdateData$delegate", "mAffairs", "", "Lcom/fxy/daymatters/bean/Affair;", "getMAffairs", "mAffairs$delegate", "mClassify", "", "getMClassify", "mClassify$delegate", "deleteAffair", "", "affair", "getAffairs", "getAffairsByClassify", "classify", "getClassify", "insertAffair", "updateAffair", "module_day_debug"})
public final class CommitAffairViewModel extends android.arch.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isInsertData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isDeleteData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy isUpdateData$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mAffairs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mClassify$delegate = null;
    private final com.fxy.daymatters.dao.DayMatterDao dataSource = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.lang.Long> isInsertData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.lang.Integer> isDeleteData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.lang.Integer> isUpdateData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.util.List<com.fxy.daymatters.bean.Affair>> getMAffairs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.util.List<java.lang.String>> getMClassify() {
        return null;
    }
    
    public final void insertAffair(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair affair) {
    }
    
    public final void deleteAffair(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair affair) {
    }
    
    public final void updateAffair(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.bean.Affair affair) {
    }
    
    public final void getAffairs() {
    }
    
    public final void getAffairsByClassify(@org.jetbrains.annotations.NotNull()
    java.lang.String classify) {
    }
    
    public final void getClassify() {
    }
    
    public CommitAffairViewModel(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.dao.DayMatterDao dataSource) {
        super();
    }
}