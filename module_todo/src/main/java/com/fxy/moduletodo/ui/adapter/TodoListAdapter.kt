package com.fxy.moduletodo.ui.adapter

import android.content.Context
import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.fxy.moduletodo.R
import com.fxy.moduletodo.bean.TodoList

/**
 * create by:Fxymine4ever
 * time: 2019/7/17
 */
class TodoListAdapter(val context:Context,var list: MutableList<TodoList>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.todo_item_rv_todolist,parent)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemView = holder.itemView

        val finish:ImageView = itemView.findViewById(R.id.todo_rv_finish)
        val important:ImageView = itemView.findViewById(R.id.todo_rv_important)
        val content:TextView = itemView.findViewById(R.id.todo_rv_content)
        //TODO:数据处理
        
    }

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

    }
}