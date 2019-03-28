package com.fxy.daymatters.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.adapter.DayMattersAdapter
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.ui.BaseFragment
import com.fxy.lib.utils.extensions.observeNotNull
import kotlinx.android.synthetic.main.day_day_fragment.*
import kotlinx.android.synthetic.main.day_day_fragment.view.*
import org.jetbrains.anko.support.v4.startActivity
import org.jetbrains.anko.support.v4.toast
import java.util.*

/**
 * create by:Fxymine4ever
 * time: 2019/3/21
 */
class DayMatterFragment : BaseFragment() {
    private lateinit var parent:View

    private lateinit var mAdapter:DayMattersAdapter

    private lateinit var list: MutableList<Affair>

    private lateinit var model: CommitAffairViewModel

    private var isGrid = true

    override val isFragmentContainer: Boolean = false

    companion object {
        val cal: Calendar = Calendar.getInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.day_day_fragment,container,false)
        context?.let {
            model = ViewModelProviders.of(this).get(CommitAffairViewModel::class.java)
            initRv(it)
            initView(it)
        }
        return parent
    }

    override fun onResume() {
        super.onResume()
        initLiveData()
    }

    private fun initLiveData(){
        model.getAffairs()
        model.mAffairs.observeNotNull(this) {affairs->
            affairs?.let {
                parent.day_main_sr.isRefreshing = false
                mAdapter.changeAffairs(affairs)
            }
        }
    }

    private fun initRv(context: Context){
        list = mutableListOf()
        mAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.GRID)
        parent.day_main_rv.adapter = mAdapter
        parent.day_main_rv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        model.getAffairs()
    }

    private fun initView(context: Context){
        val fabMenu = parent.day_main_fab_menu

        fabMenu.setClosedOnTouchOutside(false)

        parent.day_main_fab_add.setOnClickListener {
            startActivity<CommitAffairActivity>()
        }

        parent.day_main_fab_classify.setOnClickListener {
            toast("切换分类")
        }

        parent.day_main_fab_layout.setOnClickListener {
            if(!isGrid){
                parent.day_main_rv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
                val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.GRID)
                parent.day_main_rv.adapter = newAdapter
                parent.day_main_rv.requestLayout()
                isGrid = true
            }else{
                parent.day_main_rv.layoutManager = LinearLayoutManager(context)
                val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.HORIZONTAL)
                parent.day_main_rv.adapter = newAdapter
                parent.day_main_rv.requestLayout()
                isGrid = false
            }
        }
        parent.day_main_sr.setOnRefreshListener {
            parent.day_main_sr.isRefreshing = true
            model.getAffairs()
        }
    }
}