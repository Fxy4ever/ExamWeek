package com.fxy.daymatters.ui

import android.os.Bundle
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.ui.BaseViewModelActivity
import com.fxy.lib.utils.extensions.visible
import kotlinx.android.synthetic.main.day_activity_commit_matter.*
import org.jetbrains.anko.toast
import java.util.*



class CommitAffairActivity(
        override val isFragmentActivity: Boolean = false,
        override var modelClass: Class<CommitAffairViewModel> = CommitAffairViewModel::class.java
) : BaseViewModelActivity<CommitAffairViewModel>() {
    private val cal = Calendar.getInstance()

    private var title:String = ""
    private var isChineseDay:Boolean = false
    private var startDay:String = "${cal.get(Calendar.YEAR)}-${cal.get(Calendar.MONTH)}-${cal.get(Calendar.DATE)} ${getChineseDayOfWeek()}"
    private var classify:String = ""
    private var isTop:Boolean = false
    private var endDay = ""
    var isChangeActivity:Boolean = false//是否为修改页面，这关系到是否显示DeleteBtn


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.fxy.daymatters.R.layout.day_activity_commit_matter)
        common_toolbar.init("新增事件")
        initLiveData()
        initView()
    }

    private fun initLiveData(){
        model.isInsertData.observeNotNull {
            if(it!! > 0){
                toast("插入成功")
            }else{
                toast("插入失败")
            }
        }
    }

    private fun initView(){
        day_commit_btn_save.setOnClickListener {
            val title = day_commit_et_name.text.toString()
            if(title.isNotEmpty()){
                val bean = Affair()
                bean.startTime = startDay
                bean.classify = classify
                bean.title = title
                bean.endTime = endDay
                bean.isTop = isTop
                model.insertAffair(bean)
            }else{
                toast("请填写事件名称")
            }
        }
        if(isChangeActivity){
            day_commit_btn_delete.visible()
            day_commit_btn_delete.setOnClickListener {
                //删除事件
            }
        }
    }


    private fun getChineseDayOfWeek():String{
        val arr = arrayOf("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")
        return arr[cal.get(Calendar.DAY_OF_WEEK)-1]
    }
}
