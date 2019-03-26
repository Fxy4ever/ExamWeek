package com.fxy.daymatters.ui

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.adapter.DayMattersAdapter
import kotlinx.android.synthetic.main.day_day_fragment.view.*

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
class DayMatterFragment : Fragment() {
    private lateinit var parent:View

    private lateinit var mAdapter:DayMattersAdapter

    private lateinit var list: MutableList<Affair>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.day_day_fragment,container)
        context?.let {
            initRv(it)
        }
//        val db = Room.databaseBuilder(
//                BaseApp.context,
//                DayMatterDatabase::class.java,
//                "day_matter.db")
//                .build()
        return parent
    }

    private fun initRv(context: Context){
        list = mutableListOf()
        mAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.GRID)
        parent.daymatters_rv.adapter = mAdapter
        parent.daymatters_rv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
    }
}