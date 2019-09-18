package com.fxy.moduletodo.dao;

import java.lang.System;

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
@android.arch.persistence.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H\'J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/fxy/moduletodo/dao/TodoListDao;", "", "deleteTodo", "", "todo", "Lcom/fxy/moduletodo/bean/TodoList;", "getTodoList", "Lio/reactivex/Flowable;", "", "insertTodo", "", "updateTodo", "module_todo_debug"})
public abstract interface TodoListDao {
    
    @android.arch.persistence.room.Insert()
    public abstract long insertTodo(@org.jetbrains.annotations.NotNull()
    com.fxy.moduletodo.bean.TodoList todo);
    
    @android.arch.persistence.room.Update()
    public abstract int updateTodo(@org.jetbrains.annotations.NotNull()
    com.fxy.moduletodo.bean.TodoList todo);
    
    @android.arch.persistence.room.Delete()
    public abstract int deleteTodo(@org.jetbrains.annotations.NotNull()
    com.fxy.moduletodo.bean.TodoList todo);
    
    @org.jetbrains.annotations.NotNull()
    @android.arch.persistence.room.Query(value = "SELECT * FROM TodoList")
    public abstract io.reactivex.Flowable<java.util.List<com.fxy.moduletodo.bean.TodoList>> getTodoList();
}