package com.fxy.daymatters.ui;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\b\u0010\u0014\u001a\u00020\u0010H\u0002J\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0010H\u0014R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/fxy/daymatters/ui/AffairDetailActivity;", "Lcom/fxy/lib/ui/BaseActivity;", "()V", "affairs", "", "Lcom/fxy/daymatters/bean/Affair;", "curPosition", "", "isFragmentActivity", "", "()Z", "mAdapter", "Lcom/fxy/daymatters/ui/adapter/MyFragPagerAdapter;", "model", "Lcom/fxy/daymatters/viewmodel/CommitAffairViewModel;", "finishCurActivity", "", "event", "Lcom/fxy/daymatters/event/FinishDetailEvent;", "initLiveData", "initVp", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "module_day_debug"})
public final class AffairDetailActivity extends com.fxy.lib.ui.BaseActivity {
    private java.util.List<com.fxy.daymatters.bean.Affair> affairs;
    private int curPosition;
    private com.fxy.daymatters.ui.adapter.MyFragPagerAdapter mAdapter;
    private final boolean isFragmentActivity = false;
    private com.fxy.daymatters.viewmodel.CommitAffairViewModel model;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected boolean isFragmentActivity() {
        return false;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void initLiveData() {
    }
    
    private final void initVp() {
    }
    
    @org.greenrobot.eventbus.Subscribe(threadMode = org.greenrobot.eventbus.ThreadMode.MAIN)
    public final void finishCurActivity(@org.jetbrains.annotations.NotNull()
    com.fxy.daymatters.event.FinishDetailEvent event) {
    }
    
    public AffairDetailActivity() {
        super();
    }
}