package com.fxy.daymatters.ui;

import java.lang.System;

@com.alibaba.android.arouter.facade.annotation.Route(path = "/day/Affair")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00162\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\nX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/fxy/daymatters/ui/CommitAffairActivity;", "Lcom/fxy/lib/ui/BaseActivity;", "()V", "classify", "", "endChineseDay", "endDay", "id", "", "isChangeActivity", "", "isChineseDay", "isEndDay", "isFragmentActivity", "()Z", "isNotify", "model", "Lcom/fxy/daymatters/viewmodel/CommitAffairViewModel;", "startChineseDay", "startDay", "title", "initLiveData", "", "initSelect", "initView", "jugdePage", "affair", "Lcom/fxy/daymatters/bean/Affair;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "module_day_debug"})
public final class CommitAffairActivity extends com.fxy.lib.ui.BaseActivity {
    private java.lang.String title;
    private boolean isChineseDay;
    private java.lang.String startDay;
    private java.lang.String startChineseDay;
    private java.lang.String classify;
    private boolean isNotify;
    private java.lang.String endDay;
    private java.lang.String endChineseDay;
    private boolean isEndDay;
    private long id;
    private boolean isChangeActivity;
    private com.fxy.daymatters.viewmodel.CommitAffairViewModel model;
    private final boolean isFragmentActivity = false;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected boolean isFragmentActivity() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void jugdePage(com.fxy.daymatters.bean.Affair affair) {
    }
    
    private final void initLiveData() {
    }
    
    /**
     * 选择结束日期
     */
    private final void initSelect() {
    }
    
    private final void initView() {
    }
    
    public CommitAffairActivity() {
        super();
    }
}