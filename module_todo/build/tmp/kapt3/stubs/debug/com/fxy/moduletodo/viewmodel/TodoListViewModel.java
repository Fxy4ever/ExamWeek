package com.fxy.moduletodo.viewmodel;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\rR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\'\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/fxy/moduletodo/viewmodel/TodoListViewModel;", "Landroid/arch/lifecycle/ViewModel;", "dataSource", "Lcom/fxy/moduletodo/dao/TodoListDao;", "(Lcom/fxy/moduletodo/dao/TodoListDao;)V", "todoList", "Landroid/arch/lifecycle/MutableLiveData;", "", "Lcom/fxy/moduletodo/bean/TodoList;", "getTodoList", "()Landroid/arch/lifecycle/MutableLiveData;", "todoList$delegate", "Lkotlin/Lazy;", "", "Factory", "module_todo_debug"})
public final class TodoListViewModel extends android.arch.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy todoList$delegate = null;
    private final com.fxy.moduletodo.dao.TodoListDao dataSource = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.arch.lifecycle.MutableLiveData<java.util.List<com.fxy.moduletodo.bean.TodoList>> getTodoList() {
        return null;
    }
    
    public final void getTodoList() {
    }
    
    public TodoListViewModel(@org.jetbrains.annotations.Nullable()
    com.fxy.moduletodo.dao.TodoListDao dataSource) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\u0002H\u0006\"\n\b\u0000\u0010\u0006*\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00060\tH\u0016\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/fxy/moduletodo/viewmodel/TodoListViewModel$Factory;", "Landroid/arch/lifecycle/ViewModelProvider$Factory;", "dataSource", "Lcom/fxy/moduletodo/dao/TodoListDao;", "(Lcom/fxy/moduletodo/dao/TodoListDao;)V", "create", "T", "Landroid/arch/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroid/arch/lifecycle/ViewModel;", "module_todo_debug"})
    public static final class Factory implements android.arch.lifecycle.ViewModelProvider.Factory {
        private final com.fxy.moduletodo.dao.TodoListDao dataSource = null;
        
        @java.lang.Override()
        public <T extends android.arch.lifecycle.ViewModel>T create(@org.jetbrains.annotations.NotNull()
        java.lang.Class<T> modelClass) {
            return null;
        }
        
        public Factory(@org.jetbrains.annotations.NotNull()
        com.fxy.moduletodo.dao.TodoListDao dataSource) {
            super();
        }
    }
}