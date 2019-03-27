package com.fxy.daymatters.ui.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.AffairDetailActivity
import com.fxy.daymatters.util.clickWithTrigger
import com.fxy.daymatters.util.getDayFromNow
import com.fxy.daymatters.util.getToday
import com.fxy.daymatters.util.withTrigger
import com.google.gson.Gson
import kotlinx.android.synthetic.main.day_rv_item_grid.view.*
import org.jetbrains.anko.backgroundColor

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
        holder.itemView?.let {
            if(!list[position].isChineseDay){//如果不是农历
                val endTime = list[position].endTime ?: ""
                if(!endTime.isNotEmpty()){//endDay为空，说明不是计算间隔
                    val betweenDay = getDayFromNow(getToday(),list[position].startTime!! )
                    Log.d("test","${list[position].title} betweenDay=$betweenDay")
                    if(betweenDay > 0){//如果时间还没到
                        it.day_item_title.text = "${list[position].title}还有"
                        it.day_item_title.backgroundColor = context.resources.getColor(R.color.day_blue)
                    }else{  //如果时间已经过了
                        it.day_item_title.text = "${list[position].title}已经"
                        it.day_item_title.backgroundColor = context.resources.getColor(R.color.day_origin)
                    }
                    it.day_item_num.text = "${Math.abs(betweenDay)}"

                }else{
                    val betweenDay = getDayFromNow(endTime,list[position].startTime!!)
                    it.day_item_num.text = "${Math.abs(betweenDay)}"
                    it.day_item_title.text = "${list[position].title}共"
                    it.day_item_title.backgroundColor = context.resources.getColor(R.color.day_origin)
                }
            }else{//TODO:农历还没想好怎么做Orz

            }
            it.day_item_time.text = list[position].startTime
            it.clickWithTrigger{
                val intent = Intent(context,AffairDetailActivity::class.java)
                intent.putExtra("data",Gson().toJson(list))
                intent.putExtra("curPosition",position)
                context.startActivity(intent)
            }
        }
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

    fun addAffairs(list:MutableList<Affair>){
        data.addAll(list)
        notifyDataSetChanged()
    }
    fun changeAffairs(list:MutableList<Affair>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    class DayMattersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)

}