package com.fxy.moduletodo.ui

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fxy.lib.ui.BaseFragment
import com.fxy.lib.utils.extensions.observe
import com.fxy.moduletodo.R
import com.fxy.moduletodo.util.Injection
import com.fxy.moduletodo.viewmodel.TodoListViewModel
import org.jetbrains.anko.support.v4.toast

/**
 * create by:Fxymine4ever
 * time: 2019/4/9
 */
class MainFragment : BaseFragment() {
    override val isFragmentContainer: Boolean = false

    private lateinit var parent:View
    private lateinit var model:TodoListViewModel
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
        model.todoList.observe(this) { list->
            toast(list.toString())
        }
    }


}