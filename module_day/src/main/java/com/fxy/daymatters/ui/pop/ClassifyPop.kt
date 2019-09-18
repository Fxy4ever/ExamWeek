package com.fxy.daymatters.ui.pop

import android.content.Context
import android.view.View
import com.fxy.daymatters.R
import kotlinx.android.synthetic.main.day_classify_pop.view.*
import org.jetbrains.anko.toast
import razerdp.basepopup.BasePopupWindow
import android.view.animation.Animation
import com.fxy.daymatters.util.setFocused


/**
 * create by:Fxymine4ever
 * time: 2019/3/29
 */
class ClassifyPop constructor(context: Context) :
        BasePopupWindow(context) {
    private lateinit var view:View
    private lateinit var onChooseTextListener : (String) -> Unit

    override fun onCreateContentView(): View {
        view = createPopupById(R.layout.day_classify_pop)

        view.day_pop_classify_delete.setOnClickListener {
            onChooseTextListener("生活")
            dismiss()
        }

        view.day_pop_classify_save.setOnClickListener {
            val str = view.day_pop_classify_et.text.toString()
            view.day_pop_classify_et.setFocused()
            if(str.isNotEmpty()){
                onChooseTextListener(str)
                dismiss()
            }else{
                context.toast("请输入完整的分类")
            }
        }
        return view
    }

    override fun onCreateShowAnimation(): Animation {
        return getDefaultScaleAnimation(true)
    }

    override fun onCreateDismissAnimation(): Animation {
        return getDefaultScaleAnimation(false)
    }

    fun setChooseTextListener(listener:(String)->Unit){
        this.onChooseTextListener = listener
    }
}