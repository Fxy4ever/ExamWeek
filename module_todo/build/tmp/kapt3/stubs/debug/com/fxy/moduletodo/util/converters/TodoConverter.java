package com.fxy.moduletodo.util.converters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0007\u00a8\u0006\n"}, d2 = {"Lcom/fxy/moduletodo/util/converters/TodoConverter;", "", "()V", "objectToString", "", "list", "", "Lcom/fxy/moduletodo/bean/Step;", "stringToObject", "value", "module_todo_debug"})
public final class TodoConverter {
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.TypeConverter()
    public final java.util.List<com.fxy.moduletodo.bean.Step> stringToObject(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.TypeConverter()
    public final java.lang.String objectToString(@org.jetbrains.annotations.NotNull()
    java.util.List<com.fxy.moduletodo.bean.Step> list) {
        return null;
    }
    
    public TodoConverter() {
        super();
    }
}