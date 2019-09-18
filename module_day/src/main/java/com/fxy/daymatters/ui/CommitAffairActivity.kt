package com.fxy.daymatters.ui

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import com.alibaba.android.arouter.facade.annotation.Route
import com.fxy.daymatters.bean.Affair
import com.fxy.daymatters.event.FinishDetailEvent
import com.fxy.daymatters.ui.DayMatterFragment.Companion.cal
import com.fxy.daymatters.ui.pop.ClassifyPop
import com.fxy.daymatters.util.*
import com.fxy.daymatters.viewmodel.CommitAffairViewModel
import com.fxy.lib.config.DAY_AFFAIR
import com.fxy.lib.ui.BaseActivity
import com.fxy.lib.utils.extensions.*
import com.google.gson.Gson
import kotlinx.android.synthetic.main.day_activity_commit_matter.*
import org.greenrobot.eventbus.EventBus
import org.jetbrains.anko.toast
import java.util.*

@Route(path = DAY_AFFAIR)
class CommitAffairActivity : BaseActivity() {

    /*
    要设置的参数
     */
    private var title:String = ""
    private var isChineseDay:Boolean = false
    private var startDay:String = "${cal.get(Calendar.YEAR)}-${(cal.get(Calendar.MONTH))+1}-${cal.get(Calendar.DATE)} ${getChineseDayOfWeek("${cal.get(Calendar.YEAR)}-${(cal.get(Calendar.MONTH))+1}-${cal.get(Calendar.DATE)} ")}"
    private var startChineseDay:String = ""
    private var classify:String = "生活"//默认为生活
    private var isNotify:Boolean = false
    private var endDay = startDay
    private var endChineseDay:String = ""
    private var isEndDay:Boolean = false
    private var id:Long = -1
    private var isChangeActivity:Boolean = false//是否为修改页面，这关系到是否显示DeleteBtn

    private lateinit var model: CommitAffairViewModel
    override val isFragmentActivity: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.fxy.daymatters.R.layout.day_activity_commit_matter)

        val affairFromDetail = Gson().fromJson(intent.getStringExtra("affair"),Affair::class.java)
        jugdePage(affairFromDetail)
        initSelect()
        initLiveData()
        initView()
    }


    private fun jugdePage(affair: Affair?){
        if(affair == null){//新增页面
            common_toolbar.init("新增事件")
        }else{//修改页面
            common_toolbar.init("修改事件")
            affair.let {//获取传过来的内容
                id = it.dayMatterId

                title = it.title!!
                day_commit_et_name.setText(title)
                day_commit_et_name.setSingle()

                isChineseDay = it.isChineseDay
                if(isChineseDay){
                    day_commit_sw_isChineseDay.isChecked = true
                }
                startDay = it.startTime!!
                day_commit_tv_startDay.text = startDay

                //TODO:农历

                classify = it.classify!!
                day_commit_tv_classify.text = classify

                isNotify = it.isNotify
                if(isNotify){
                    day_commit_sw_notify.isChecked = true
                }

                it.endTime?.let {endTime->
                    endDay = endTime
                    isEndDay = true
                    day_commit_sw_isEnd.isChecked = true
                    day_commit_choose_endDay.visible()
                }

                isChangeActivity = true

                it.background?.let {background->
                    //TODO: 背景图片
                }

                isChangeActivity = true
            }
        }
    }

    private fun initLiveData(){
        val factory = Injection.provideViewModelFactory(this)
        model = ViewModelProviders.of(this,factory).get(CommitAffairViewModel::class.java)
        model.isInsertData.observeNotNull (this){
            if(it!! > 0){
                toast("插入成功")
                finish()
            }
        }

        model.isDeleteData.observeNotNull (this){
            if(it!! > 0){
                toast("删除成功")
                EventBus.getDefault().post(FinishDetailEvent())
                finish()
            }
        }

        model.isUpdateData.observeNotNull (this){
            if(it!! > 0){
                toast("修改成功")
                EventBus.getDefault().post(FinishDetailEvent())
                finish()
            }
        }
    }

    /**
     * 选择结束日期
     */
    private fun initSelect(){
        //开始日期选择
        val dateStartPicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->

            startDay = "$year-${month+1}-$dayOfMonth ${getChineseDayOfWeek("$year-${month+1}-$dayOfMonth")}"
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

        day_commit_sw_notify.setOnCheckedChangeListener { _, isChecked ->
            isNotify = isChecked//是否置顶
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
            else{
                day_commit_choose_endDay.gone()
                endDay = ""
            }


        }
    }

    private fun initView(){
        day_commit_tv_startDay.text = startDay
        day_commit_tv_endDay.text = endDay
        day_commit_tv_classify.text = classify

        day_commit_btn_save.setOnClickListener {
            title = day_commit_et_name.text.toString()
            if(title.isNotEmpty()){
                val bean = Affair()
                bean.startTime = startDay
                bean.classify = classify
                bean.title = title
                bean.isNotify = isNotify
                bean.isChineseDay = isChineseDay
                if(isEndDay){
                    bean.endTime = endDay
                }
                if(isChangeActivity){//修改页面
                    bean.dayMatterId = id//如果是更新，得设置一个id
                    model.updateAffair(bean)
                }else{//添加页面
                    model.insertAffair(bean)
                }
            }else{
                toast("请填写事件名称")
            }
        }
        if(isChangeActivity){
            day_commit_btn_delete.visible()
            day_commit_btn_delete.setOnClickListener {
                val bean = Affair()
                bean.dayMatterId = id
                model.deleteAffair(bean)
            }
        }

        val classifyPop = ClassifyPop(this)
        classifyPop.popupGravity = Gravity.CENTER

        classifyPop.setChooseTextListener{
            classify = it
            day_commit_tv_classify.text = it
        }
        day_commit_tv_classify.setOnClickListener {
            classifyPop.showPopupWindow()
        }
    }
}
