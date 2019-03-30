package com.fxy.daymatters.ui

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.daymatters.R
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.bean.Classify
import com.fxy.daymatters.ui.adapter.DayMattersAdapter
import com.fxy.daymatters.ui.pop.ClassifyListPop
import com.fxy.daymatters.ui.widget.AffairSmallWidget
import com.fxy.daymatters.util.Injection
import com.fxy.daymatters.viewmodel.AffairViewModelFactory
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.ui.BaseFragment
import com.fxy.lib.utils.extensions.editor
import com.fxy.lib.utils.extensions.gone
import com.fxy.lib.utils.extensions.observeNotNull
import com.fxy.lib.utils.extensions.visible
import com.google.gson.Gson
import kotlinx.android.synthetic.main.day_day_fragment.view.*
import org.jetbrains.anko.defaultSharedPreferences
import org.jetbrains.anko.sp
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

    private lateinit var listPop: ClassifyListPop

    override val isFragmentContainer: Boolean = false

    companion object {
        val cal: Calendar = Calendar.getInstance(Locale.CHINA)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.day_day_fragment,container,false)
        context?.let {
            val factory = AffairViewModelFactory(Injection.provideAffariDataSrouce(it))
            model = ViewModelProviders.of(this,factory).get(CommitAffairViewModel::class.java)
            initLiveData(it)
            initRv(it)
            initView(it)
        }
        return parent
    }
    override fun onResume() {
        super.onResume()
        model.getAffairs()
        model.getClassify()
    }

    private fun initLiveData(context: Context){
        model.getAffairs()
        model.mAffairs.observeNotNull(this) {affairs->
            affairs?.let {
                if(affairs.size == 0){
                    parent.day_main_sr.gone()
                }else{
                    parent.day_main_sr.visible()
                }
                context.defaultSharedPreferences.editor {
                    putString(AffairSmallWidget.sharedName, Gson().toJson(affairs))
                }
                refreshClassify(context)
                parent.day_main_sr.isRefreshing = false
                mAdapter.changeAffairs(affairs)
            }
        }
        model.mClassify.observeNotNull(this){classifies->
            context.defaultSharedPreferences.editor {
                val mutableList = mutableListOf<Classify>()
                classifies?.forEach {
                    mutableList.add(Classify(it))
                }
                putString(AffairSmallWidget.sharedClassify, Gson().toJson(mutableList))
            }
            listPop = if(classifies!=null&&classifies.size>0){
                ClassifyListPop(context,classifies)
            }else{
                ClassifyListPop(context, mutableListOf())
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

        //添加fab
        parent.day_main_fab_add.setOnClickListener {
            startActivity<CommitAffairActivity>()
            fabMenu.close(true)
        }


        //分类fab
        parent.day_main_fab_classify.setOnClickListener {
            toast("切换分类")
            model.getClassify()
            listPop.showPopupWindow()
            listPop.setListener {
                if(it == "全部"){
                    model.getAffairs()
                }else{
                    model.getAffairsByClassify(it)
                }
            }
            fabMenu.close(true)
        }

        //更换布局fab
        parent.day_main_fab_layout.setOnClickListener {
            refreshRv(context)
            fabMenu.close(true)
        }
        parent.day_main_sr.setOnRefreshListener {
            parent.day_main_sr.isRefreshing = true
            model.getAffairs()
        }
    }

    fun refreshRv(context: Context){
        if(!isGrid){
            parent.day_main_rv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.GRID)
            parent.day_main_rv.adapter = newAdapter
            parent.day_main_rv.requestLayout()
        }else{
            parent.day_main_rv.layoutManager = LinearLayoutManager(context)
            val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.HORIZONTAL)
            parent.day_main_rv.adapter = newAdapter
            parent.day_main_rv.requestLayout()
        }
        isGrid = !isGrid
    }

    private fun refreshClassify(context: Context){
        if(isGrid){
            parent.day_main_rv.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.GRID)
            parent.day_main_rv.adapter = newAdapter
            parent.day_main_rv.requestLayout()
        }else{
            parent.day_main_rv.layoutManager = LinearLayoutManager(context)
            val newAdapter = DayMattersAdapter(list,context,DayMattersAdapter.ItemType.HORIZONTAL)
            parent.day_main_rv.adapter = newAdapter
            parent.day_main_rv.requestLayout()
        }
    }
}