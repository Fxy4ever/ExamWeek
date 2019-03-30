package com.fxy.daymatters.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.util.getDayFromNow
import com.fxy.daymatters.util.getToday
import kotlinx.android.synthetic.main.day_fragment_detail.view.*
import org.jetbrains.anko.backgroundColor

/**
 * create by:Fxymine4ever
 * time: 2019/3/27
 */
class AffairDetailFragment : Fragment() {
    lateinit var affair: Affair
    private lateinit var parent:View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.day_fragment_detail,container,false)
        initView()
        return parent
    }

    private fun initView(){
        context?.let {context->
            if(!affair.isChineseDay&&affair!=null){//如果不是农历
                val endTime = affair.endTime ?: ""
                if(!endTime.isNotEmpty()){//endDay为空，说明不是计算间隔
                    val betweenDay = getDayFromNow(getToday(),affair.startTime!! )
                    if(betweenDay > 0){//如果时间还没到
                        parent.day_detail_title.text = "${affair.title}还有"
                        parent.day_detail_title.backgroundColor = context.resources.getColor(R.color.day_blue)
                    }else{  //如果时间已经过了
                        parent.day_detail_title.text = "${affair.title}已经"
                        parent.day_detail_title.backgroundColor = context.resources.getColor(R.color.day_origin)
                    }
                    parent.day_detail_num.text = "${Math.abs(betweenDay)}"

                }else{
                    val betweenDay = getDayFromNow(endTime,affair.startTime!!)
                    parent.day_detail_num.text = "${Math.abs(betweenDay)}"
                    parent.day_detail_title.text = "${affair.title}共"
                    parent.day_detail_title.backgroundColor = context.resources.getColor(R.color.day_origin)
                }
            }else{//TODO:农历还没想好怎么做Orz

            }
            parent.day_detail_time.text = affair.startTime
        }
    }
}