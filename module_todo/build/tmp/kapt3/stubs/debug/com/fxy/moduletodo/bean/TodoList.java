package com.fxy.moduletodo.bean;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@android.arch.persistence.room.TypeConverters(value = {com.fxy.moduletodo.util.converters.TodoConverter.class})
@android.arch.persistence.room.Entity(tableName = "TodoList")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u000fJ\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\'\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\bH\u00c6\u0003J\t\u0010)\u001a\u00020\bH\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\u0011\u0010+\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u00c6\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003Jg\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010.\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u000100H\u00d6\u0003J\t\u00101\u001a\u000202H\u00d6\u0001J\t\u00103\u001a\u00020\u0005H\u00d6\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u001a\"\u0004\b\u001d\u0010\u001cR\u001e\u0010\n\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u001a\"\u0004\b\u001e\u0010\u001cR \u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R&\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u00064"}, d2 = {"Lcom/fxy/moduletodo/bean/TodoList;", "Ljava/io/Serializable;", "id", "", "content", "", "deadLine", "isAddMyDay", "", "isFinish", "isImportant", "steps", "", "Lcom/fxy/moduletodo/bean/Step;", "notes", "(JLjava/lang/String;Ljava/lang/String;ZZZLjava/util/List;Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getDeadLine", "setDeadLine", "getId", "()J", "setId", "(J)V", "()Z", "setAddMyDay", "(Z)V", "setFinish", "setImportant", "getNotes", "setNotes", "getSteps", "()Ljava/util/List;", "setSteps", "(Ljava/util/List;)V", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "module_todo_debug"})
public final class TodoList implements java.io.Serializable {
    @android.arch.persistence.room.ColumnInfo(name = "id")
    @android.arch.persistence.room.PrimaryKey(autoGenerate = true)
    private long id;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "content")
    private java.lang.String content;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "deadLine")
    private java.lang.String deadLine;
    @android.arch.persistence.room.ColumnInfo(name = "isAddMyDay")
    private boolean isAddMyDay;
    @android.arch.persistence.room.ColumnInfo(name = "isFinish")
    private boolean isFinish;
    @android.arch.persistence.room.ColumnInfo(name = "isImportant")
    private boolean isImportant;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "steps")
    private java.util.List<com.fxy.moduletodo.bean.Step> steps;
    @org.jetbrains.annotations.Nullable()
    @android.arch.persistence.room.ColumnInfo(name = "notes")
    private java.lang.String notes;
    
    public final long getId() {
        return 0L;
    }
    
    public final void setId(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContent() {
        return null;
    }
    
    public final void setContent(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDeadLine() {
        return null;
    }
    
    public final void setDeadLine(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean isAddMyDay() {
        return false;
    }
    
    public final void setAddMyDay(boolean p0) {
    }
    
    public final boolean isFinish() {
        return false;
    }
    
    public final void setFinish(boolean p0) {
    }
    
    public final boolean isImportant() {
        return false;
    }
    
    public final void setImportant(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.fxy.moduletodo.bean.Step> getSteps() {
        return null;
    }
    
    public final void setSteps(@org.jetbrains.annotations.Nullable()
    java.util.List<com.fxy.moduletodo.bean.Step> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNotes() {
        return null;
    }
    
    public final void setNotes(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public TodoList(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String content, @org.jetbrains.annotations.Nullable()
    java.lang.String deadLine, boolean isAddMyDay, boolean isFinish, boolean isImportant, @org.jetbrains.annotations.Nullable()
    java.util.List<com.fxy.moduletodo.bean.Step> steps, @org.jetbrains.annotations.Nullable()
    java.lang.String notes) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.fxy.moduletodo.bean.Step> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component8() {
        return null;
    }
    
    /**
     * create by:Fxymine4ever
     * time: 2019/7/17
     */
    @org.jetbrains.annotations.NotNull()
    public final com.fxy.moduletodo.bean.TodoList copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.String content, @org.jetbrains.annotations.Nullable()
    java.lang.String deadLine, boolean isAddMyDay, boolean isFinish, boolean isImportant, @org.jetbrains.annotations.Nullable()
    java.util.List<com.fxy.moduletodo.bean.Step> steps, @org.jetbrains.annotations.Nullable()
    java.lang.String notes) {
        return null;
    }
    
    /**
     * create by:Fxymine4ever
     * time: 2019/7/17
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * create by:Fxymine4ever
     * time: 2019/7/17
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * create by:Fxymine4ever
     * time: 2019/7/17
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}