package com.fxy.daymatters.ui.pop;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fxy.daymatters.R;
import com.fxy.daymatters.bean.Classify;

import java.util.List;

import razerdp.basepopup.BasePopupWindow;

/**
 * create by:Fxymine4ever
 * time: 2019/3/30
 */
public class ClassifyListPop extends BasePopupWindow {

    private OnGetChooseListener listener;

    public void setListener(OnGetChooseListener listener) {
        this.listener = listener;
    }

    public ClassifyListPop(Context context, List<Classify> data){
        super(context);
        System.out.println("classify");
        if(data!=null && data.size()>0){
            ViewGroup container = findViewById(R.id.day_pop_classify_list_layout);
            for (Classify s : data) {
                TextView textView = new TextView(context);
                textView.setPadding(0,20,0,20);
                textView.setText(s.getName());
                textView.setGravity(Gravity.CENTER);
                textView.setTextSize(18.0f);
                textView.setTextColor(Color.parseColor("#000000"));
                textView.setOnClickListener(v->{
                    listener.OnGetChoose(s.getName());
                    dismiss();
                });
                container.addView(textView);
            }
        }
        setPopupGravity(Gravity.CENTER);
    }

    @Override
    public View onCreateContentView() {
        return createPopupById(R.layout.day_classify_list_pop);
    }

    @Override
    protected Animation onCreateShowAnimation() {
        return getDefaultScaleAnimation(true);
    }

    @Override
    protected Animation onCreateDismissAnimation() {
        return getDefaultScaleAnimation(false);
    }

    public interface OnGetChooseListener{
        void OnGetChoose(String choose);
    }
}
