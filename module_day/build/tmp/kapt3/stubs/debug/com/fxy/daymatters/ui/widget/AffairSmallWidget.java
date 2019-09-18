package com.fxy.daymatters.ui.widget;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0002J\b\u0010\r\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J \u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J \u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0018\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u00a8\u0006\""}, d2 = {"Lcom/fxy/daymatters/ui/widget/AffairSmallWidget;", "Landroid/appwidget/AppWidgetProvider;", "()V", "getClickPendingIntent", "Landroid/app/PendingIntent;", "context", "Landroid/content/Context;", "resId", "", "action", "", "clazz", "Ljava/lang/Class;", "getLeftButtonId", "getRemotesView", "Landroid/widget/RemoteViews;", "getRightButtonId", "getTitleTextViewId", "onReceive", "", "intent", "Landroid/content/Intent;", "onUpdate", "appWidgetManager", "Landroid/appwidget/AppWidgetManager;", "appWidgetIds", "", "refresh", "setListView", "rv", "classify", "show", "remoteViews", "Companion", "module_day_debug"})
public final class AffairSmallWidget extends android.appwidget.AppWidgetProvider {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String sharedName = "com.fxy.exam.widget";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String sharedClassify = "com.fxy.exam.classify";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BTN_CLICK = "com.fxy.exam.widget.click";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLLECTION_VIEW_EXTRA = "com.fxy.exam.widget.view.extra";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String COLLECTION_VIEW_ACTION = "com.fxy.exam.widget.view.action";
    private static int curPosition;
    @org.jetbrains.annotations.NotNull()
    public static java.util.List<com.fxy.daymatters.bean.Classify> classify;
    private static int widgetId;
    @org.jetbrains.annotations.NotNull()
    public static java.lang.String curClassify;
    public static final com.fxy.daymatters.ui.widget.AffairSmallWidget.Companion Companion = null;
    
    @java.lang.Override()
    public void onUpdate(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.appwidget.AppWidgetManager appWidgetManager, @org.jetbrains.annotations.NotNull()
    int[] appWidgetIds) {
    }
    
    private final void setListView(android.content.Context context, android.widget.RemoteViews rv, java.lang.String classify) {
    }
    
    private final void refresh(android.content.Context context) {
    }
    
    private final void show(android.widget.RemoteViews remoteViews, android.content.Context context) {
    }
    
    private final android.app.PendingIntent getClickPendingIntent(android.content.Context context, @android.support.annotation.IdRes()
    int resId, java.lang.String action, java.lang.Class<android.appwidget.AppWidgetProvider> clazz) {
        return null;
    }
    
    @java.lang.Override()
    public void onReceive(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final int getLeftButtonId() {
        return 0;
    }
    
    private final int getRightButtonId() {
        return 0;
    }
    
    private final int getTitleTextViewId() {
        return 0;
    }
    
    private final android.widget.RemoteViews getRemotesView(android.content.Context context) {
        return null;
    }
    
    public AffairSmallWidget() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0016\"\u0004\b\u001d\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/fxy/daymatters/ui/widget/AffairSmallWidget$Companion;", "", "()V", "BTN_CLICK", "", "COLLECTION_VIEW_ACTION", "COLLECTION_VIEW_EXTRA", "classify", "", "Lcom/fxy/daymatters/bean/Classify;", "getClassify", "()Ljava/util/List;", "setClassify", "(Ljava/util/List;)V", "curClassify", "getCurClassify", "()Ljava/lang/String;", "setCurClassify", "(Ljava/lang/String;)V", "curPosition", "", "getCurPosition", "()I", "setCurPosition", "(I)V", "sharedClassify", "sharedName", "widgetId", "getWidgetId", "setWidgetId", "module_day_debug"})
    public static final class Companion {
        
        public final int getCurPosition() {
            return 0;
        }
        
        public final void setCurPosition(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<com.fxy.daymatters.bean.Classify> getClassify() {
            return null;
        }
        
        public final void setClassify(@org.jetbrains.annotations.NotNull()
        java.util.List<com.fxy.daymatters.bean.Classify> p0) {
        }
        
        public final int getWidgetId() {
            return 0;
        }
        
        public final void setWidgetId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getCurClassify() {
            return null;
        }
        
        public final void setCurClassify(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        private Companion() {
            super();
        }
    }
}