package com.fxy.daymatters.ui

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.ui.DayMatterFragment.Companion.cal
import com.fxy.daymatters.util.ChinaDate
import com.fxy.daymatters.util.getChineseDayOfWeek
import com.fxy.daymatters.util.getDateFromString
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.ui.BaseActivity
import com.fxy.lib.utils.extensions.gone
import com.fxy.lib.utils.extensions.observeNotNull
import com.fxy.lib.utils.extensions.visible
import kotlinx.android.synthetic.main.day_activity_commit_matter.*
import org.jetbrains.anko.toast
import java.util.*


class CommitAffairActivity : BaseActivity() {

    private var title:String = ""
    private var isChineseDay:Boolean = false
    private var startDay:String = "${cal.get(Calendar.YEAR)}-${cal.get(Calendar.MONTH)+1}-${cal.get(Calendar.DATE)} ${getChineseDayOfWeek("${cal.get(Calendar.YEAR)}-${cal.get(Calendar.MONTH)}-${cal.get(Calendar.DATE)} ")}"
    private var startChineseDay:String = ""
    private var classify:String = "生活"//默认为生活
    private var isTop:Boolean = false
    private var endDay = startDay
    private var endChineseDay:String = ""
    private var isEndDay:Boolean = false
    var isChangeActivity:Boolean = false//是否为修改页面，这关系到是否显示DeleteBtn

    private lateinit var model: CommitAffairViewModel
    override val isFragmentActivity: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.fxy.daymatters.R.layout.day_activity_commit_matter)
        common_toolbar.init("新增事件")
        initSelect()
        initLiveData()
        initView()
    }

    private fun initLiveData(){
        model = ViewModelProviders.of(this).get(CommitAffairViewModel::class.java)
        model.isInsertData.observeNotNull (this){
            if(it!! > 0){
                toast("插入成功")
                finish()
            }
        }
    }

    /**
     * 选择结束日期
     */
    private fun initSelect(){
        //开始日期选择
        val cal = Calendar.getInstance()
        val dateStartPicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->

            startDay = "$year-${month+1}-$dayOfMonth ${getChineseDayOfWeek("$year-${month+1}-$dayOfMonth")}"
            Log.d("fxy",month.toString())
            if(isChineseDay){
                val startDates = getDateFromString(startDay)
                startChineseDay = ChinaDate.oneDay(startDates[0],startDates[1],startDates[2])
                day_commit_tv_startDay.text = startChineseDay
            }else{
                day_commit_tv_startDay.text = startDay
            }
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

        day_commit_choose_startDay.setOnClickListener {
            dateStartPicker.show()
        }

        //结束日期选择
        val dateEndPicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->
            endDay = "$year-${month+1}-$dayOfMonth ${getChineseDayOfWeek("$year-${month+1}-$dayOfMonth")}"
            if(isChineseDay){
                val endDates = getDateFromString(endDay)
                endChineseDay = ChinaDate.oneDay(endDates[0],endDates[1],endDates[2])
                day_commit_tv_endDay.text = endChineseDay
            }else{
                day_commit_tv_endDay.text = endDay
            }
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))

        day_commit_choose_endDay.setOnClickListener {
            dateEndPicker.show()
        }

        day_commit_sw_isTop.setOnCheckedChangeListener { _, isChecked ->
            isTop = isChecked//是否置顶
        }

        day_commit_sw_isChineseDay.setOnCheckedChangeListener { _, isChecked ->
            isChineseDay = isChecked
            if(isChecked){//是否选择农历 //TODO:后期换上农历的日期选择
                val startDates = getDateFromString(startDay)
                startChineseDay = ChinaDate.oneDay(startDates[0],startDates[1],startDates[2])
                val endDates = getDateFromString(endDay)
                endChineseDay = ChinaDate.oneDay(endDates[0],endDates[1],endDates[2])

                day_commit_tv_startDay.text = startChineseDay
                day_commit_tv_endDay.text = endChineseDay
            }else{
                day_commit_tv_startDay.text = startDay
                day_commit_tv_endDay.text = endDay
            }
        }

        day_commit_sw_isEnd.setOnCheckedChangeListener { _, isChecked ->
            isEndDay = isChecked
            if(isChecked)
                day_commit_choose_endDay.visible()
            else
                day_commit_choose_endDay.gone()

        }
    }

    private fun initView(){
        day_commit_tv_startDay.text = startDay
        Log.d("test",endDay)
        day_commit_tv_endDay.text = endDay
        day_commit_tv_classify.text = classify
        day_commit_btn_save.setOnClickListener {
            val title = day_commit_et_name.text.toString()
            if(title.isNotEmpty()){
                val bean = Affair()
                bean.startTime = startDay
                bean.classify = classify
                bean.title = title
                bean.isChineseDay = isChineseDay
                if(isEndDay){
                    bean.endTime = endDay
                }
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
}
