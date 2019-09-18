package com.fxy.daymatters.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 2, d1 = {"\u00000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a-\u0010\f\u001a\u00020\r\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u0011\u001a\u00020\u0012\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u0003H\u0002\u00a2\u0006\u0002\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\r\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\u0002\u0010\u0016\u001a\n\u0010\u0017\u001a\u00020\r*\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\r*\u00020\u0018\u001a#\u0010\u001a\u001a\u0002H\u0003\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u0001\u00a2\u0006\u0002\u0010\u001c\"2\u0010\u0002\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0006\u0010\u0000\u001a\u00020\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\"2\u0010\t\u001a\u00020\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004*\u0002H\u00032\u0006\u0010\u0000\u001a\u00020\u00018B@BX\u0082\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\u001d"}, d2 = {"value", "", "triggerDelay", "T", "Landroid/view/View;", "getTriggerDelay", "(Landroid/view/View;)J", "setTriggerDelay", "(Landroid/view/View;J)V", "triggerLastTime", "getTriggerLastTime", "setTriggerLastTime", "click", "", "block", "Lkotlin/Function1;", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "clickEnable", "", "(Landroid/view/View;)Z", "clickWithTrigger", "time", "(Landroid/view/View;JLkotlin/jvm/functions/Function1;)V", "setFocused", "Landroid/widget/EditText;", "setSingle", "withTrigger", "delay", "(Landroid/view/View;J)Landroid/view/View;", "module_day_debug"})
public final class UtilsKt {
    
    /**
     * *
     * 设置延迟时间的View扩展
     * @param delay Long 延迟时间，默认600毫秒
     * @return T
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends android.view.View>T withTrigger(@org.jetbrains.annotations.NotNull()
    T $this$withTrigger, long delay) {
        return null;
    }
    
    /**
     * *
     * 点击事件的View扩展
     * @param block: (T) -> Unit 函数
     * @return Unit
     */
    public static final <T extends android.view.View>void click(@org.jetbrains.annotations.NotNull()
    T $this$click, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
    }
    
    /**
     * *
     * 带延迟过滤的点击事件View扩展
     * @param delay Long 延迟时间，默认600毫秒
     * @param block: (T) -> Unit 函数
     * @return Unit
     */
    public static final <T extends android.view.View>void clickWithTrigger(@org.jetbrains.annotations.NotNull()
    T $this$clickWithTrigger, long time, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> block) {
    }
    
    private static final <T extends android.view.View>long getTriggerLastTime(@org.jetbrains.annotations.NotNull()
    T $this$triggerLastTime) {
        return 0L;
    }
    
    private static final <T extends android.view.View>void setTriggerLastTime(@org.jetbrains.annotations.NotNull()
    T $this$triggerLastTime, long value) {
    }
    
    private static final <T extends android.view.View>long getTriggerDelay(@org.jetbrains.annotations.NotNull()
    T $this$triggerDelay) {
        return 0L;
    }
    
    private static final <T extends android.view.View>void setTriggerDelay(@org.jetbrains.annotations.NotNull()
    T $this$triggerDelay, long value) {
    }
    
    private static final <T extends android.view.View>boolean clickEnable(@org.jetbrains.annotations.NotNull()
    T $this$clickEnable) {
        return false;
    }
    
    public static final void setFocused(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setFocused) {
    }
    
    public static final void setSingle(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$setSingle) {
    }
}