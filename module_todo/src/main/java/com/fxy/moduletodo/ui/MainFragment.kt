package com.fxy.moduletodo.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.alibaba.android.arouter.facade.annotation.Route
import com.fxy.lib.config.TODO_MAIN
import com.fxy.lib.ui.BaseFragment
import com.fxy.lib.utils.extensions.observe
import com.fxy.moduletodo.R
import com.fxy.moduletodo.bean.TodoList
import com.fxy.moduletodo.ui.adapter.TodoListAdapter
import com.fxy.moduletodo.util.Injection
import com.fxy.moduletodo.viewmodel.TodoListViewModel
import kotlinx.android.synthetic.main.todo_fragment_main.*
import kotlinx.android.synthetic.main.todo_fragment_main.view.*

/**
 * create by:Fxymine4ever
 * time: 2019/4/9
 */

@Route(path = TODO_MAIN)
class MainFragment : BaseFragment() {
    override val isFragmentContainer: Boolean = false

    private lateinit var parent:View
    private lateinit var model:TodoListViewModel
    private val list: MutableList<TodoList> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        parent = inflater.inflate(R.layout.todo_fragment_main,container,false)
        if (context == null) return null
        val factory = TodoListViewModel.Factory(Injection.provideAffariDataSrouce(context!!))
        model = ViewModelProviders.of(this,factory).get(TodoListViewModel::class.java)

        initData()
        return parent
    }

    private fun initData(){
        model.getTodoList()
        val mAdapter = TodoListAdapter(context!!,list)
        parent.todo_main_rv.adapter = mAdapter
        parent.todo_main_rv.layoutManager = LinearLayoutManager(context!!)

        model.todoList.observe(this) { list->
            if(list != null  && list.size > 0){
                this.list.addAll(list)
            }
        }
    }


}