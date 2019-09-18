package com.fxy.daymatters.ui.widget;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/fxy/daymatters/ui/widget/AffairWidgetService;", "Landroid/widget/RemoteViewsService;", "()V", "onGetViewFactory", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "intent", "Landroid/content/Intent;", "AffairWidgetFactory", "module_day_debug"})
public final class AffairWidgetService extends android.widget.RemoteViewsService {
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.widget.RemoteViewsService.RemoteViewsFactory onGetViewFactory(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return null;
    }
    
    public AffairWidgetService() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001dH\u0016J \u0010!\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\n2\u0006\u0010#\u001a\u00020\u0017H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006$"}, d2 = {"Lcom/fxy/daymatters/ui/widget/AffairWidgetService$AffairWidgetFactory;", "Landroid/widget/RemoteViewsService$RemoteViewsFactory;", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "classify", "", "(Lcom/fxy/daymatters/ui/widget/AffairWidgetService;Landroid/content/Context;Landroid/content/Intent;Ljava/lang/String;)V", "appWidgetId", "", "getClassify", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "data", "", "Lcom/fxy/daymatters/bean/Affair;", "getCount", "getItemId", "", "position", "getLoadingView", "Landroid/widget/RemoteViews;", "getViewAt", "getViewTypeCount", "hasStableIds", "", "initData", "", "onCreate", "onDataSetChanged", "onDestroy", "setFillIntent", "id", "rv", "module_day_debug"})
    public final class AffairWidgetFactory implements android.widget.RemoteViewsService.RemoteViewsFactory {
        private java.util.List<com.fxy.daymatters.bean.Affair> data;
        private int appWidgetId;
        @org.jetbrains.annotations.NotNull()
        private final android.content.Context context = null;
        private final android.content.Intent intent = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String classify = null;
        
        @java.lang.Override()
        public void onCreate() {
        }
        
        private final void initData() {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.widget.RemoteViews getViewAt(int position) {
            return null;
        }
        
        private final void setFillIntent(int position, int id, android.widget.RemoteViews rv) {
        }
        
        @org.jetbrains.annotations.Nullable()
        @java.lang.Override()
        public android.widget.RemoteViews getLoadingView() {
            return null;
        }
        
        @java.lang.Override()
        public long getItemId(int position) {
            return 0L;
        }
        
        @java.lang.Override()
        public void onDataSetChanged() {
        }
        
        @java.lang.Override()
        public boolean hasStableIds() {
            return false;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        @java.lang.Override()
        public int getViewTypeCount() {
            return 0;
        }
        
        @java.lang.Override()
        public void onDestroy() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.content.Context getContext() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getClassify() {
            return null;
        }
        
        public AffairWidgetFactory(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.Intent intent, @org.jetbrains.annotations.NotNull()
        java.lang.String classify) {
            super();
        }
    }
}