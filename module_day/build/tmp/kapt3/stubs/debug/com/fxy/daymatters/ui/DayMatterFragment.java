package com.fxy.daymatters.ui;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
@com.alibaba.android.arouter.facade.annotation.Route(path = "/day/Main")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010\u00132\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010\'\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010(\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006*"}, d2 = {"Lcom/fxy/daymatters/ui/DayMatterFragment;", "Lcom/fxy/lib/ui/BaseFragment;", "()V", "classlist", "", "Lcom/fxy/daymatters/bean/Classify;", "isFragmentContainer", "", "()Z", "isGrid", "list", "Lcom/fxy/daymatters/bean/Affair;", "listPop", "Lcom/fxy/daymatters/ui/pop/ClassifyListPop;", "mAdapter", "Lcom/fxy/daymatters/ui/adapter/DayMattersAdapter;", "model", "Lcom/fxy/daymatters/viewmodel/CommitAffairViewModel;", "parent", "Landroid/view/View;", "getParent", "()Landroid/view/View;", "setParent", "(Landroid/view/View;)V", "initLiveData", "", "context", "Landroid/content/Context;", "initRv", "initView", "initWorkManager", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "refreshClassify", "refreshRv", "Companion", "module_day_debug"})
public final class DayMatterFragment extends com.fxy.lib.ui.BaseFragment {
    @org.jetbrains.annotations.NotNull()
    public android.view.View parent;
    private com.fxy.daymatters.ui.adapter.DayMattersAdapter mAdapter;
    private java.util.List<com.fxy.daymatters.bean.Affair> list;
    private com.fxy.daymatters.viewmodel.CommitAffairViewModel model;
    private boolean isGrid;
    private com.fxy.daymatters.ui.pop.ClassifyListPop listPop;
    private final boolean isFragmentContainer = false;
    private final java.util.List<com.fxy.daymatters.bean.Classify> classlist = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Calendar cal = null;
    public static final com.fxy.daymatters.ui.DayMatterFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.View getParent() {
        return null;
    }
    
    public final void setParent(@org.jetbrains.annotations.NotNull()
    android.view.View p0) {
    }
    
    @java.lang.Override()
    protected boolean isFragmentContainer() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void initLiveData(android.content.Context context) {
    }
    
    private final void initRv(android.content.Context context) {
    }
    
    private final void initView(android.content.Context context) {
    }
    
    public final void refreshRv(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void refreshClassify(android.content.Context context) {
    }
    
    private final void initWorkManager() {
    }
    
    public DayMatterFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/fxy/daymatters/ui/DayMatterFragment$Companion;", "", "()V", "cal", "Ljava/util/Calendar;", "getCal", "()Ljava/util/Calendar;", "module_day_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.Calendar getCal() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}