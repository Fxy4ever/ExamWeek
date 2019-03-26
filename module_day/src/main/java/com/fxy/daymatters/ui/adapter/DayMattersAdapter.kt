package com.fxy.daymatters.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
class DayMattersAdapter(private var list:MutableList<Affair>,
                        private val context:Context,
                        private var itemType:ItemType)
    : RecyclerView.Adapter<DayMattersAdapter.DayMattersViewHolder>() {

    var data:MutableList<Affair> = list

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DayMattersViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayMattersViewHolder{
        return if (itemType == ItemType.GRID)
            DayMattersViewHolder(LayoutInflater.from(context).inflate(R.layout.day_rv_item_grid,parent,false))
        else
            DayMattersViewHolder(LayoutInflater.from(context).inflate(R.layout.day_rv_item_horizontal,parent,false))
    }

    enum class ItemType{
        GRID,HORIZONTAL
    }

    class DayMattersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}