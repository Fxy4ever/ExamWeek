package com.fxy.moduletodo.ui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RoundView extends View {

    private int mWidth = 50;//默认
    private int mHeight = 50;
    private Paint titlePaint;
    private Paint doPaint;

    private String titleStr = "";
    private Map<String,Float> map;
    private Rect textRect;
    private RectF rectF;
    private ValueAnimator animator;
    private int[] colors = {Color.BLUE,Color.RED,Color.GRAY,Color.YELLOW};
    private int defaultSize = 20;
    private int radius = 0;
    private float animatedValue;


    public RoundView(Context context) {
        super(context);
        init();
    }

    public RoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        titlePaint = new Paint();
        titlePaint.setTextSize(sp2px(defaultSize));

        textRect = new Rect();

        doPaint = new Paint();
        doPaint.setAlpha(25);
        doPaint.setAntiAlias(true);
        doPaint.setShadowLayer(5,5,5,Color.GRAY);

        rectF = new RectF();

        setPadding(dp2px(5),dp2px(5),dp2px(5),dp2px(5));

        animator = ValueAnimator.ofFloat(0,1);
        animator.setDuration(5000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(valueAnimator -> {
            animatedValue = (float) valueAnimator.getAnimatedValue();
            invalidate();
        });

    }

    public void setChange(Map<String,Float> map, String titleStr){
        this.map = map;
        this.titleStr = titleStr;
        animator.start();
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        titlePaint.getTextBounds(titleStr,0,titleStr.length(),textRect);
        mWidth = dp2px(mWidth);
        mHeight = dp2px(mHeight);
        mHeight += textRect.height();
        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth+getPaddingLeft()+getPaddingRight(), mHeight+getPaddingBottom()+getPaddingTop());
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth+getPaddingLeft()+getPaddingRight(), heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, mHeight+getPaddingBottom()+getPaddingTop());
        }
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        radius = Math.min(getMeasuredWidth(),getMeasuredHeight())/3;

        int X = getMeasuredWidth() / 2;
        int Y = getMeasuredHeight() / 2;
        rectF.left = X  - radius;
        rectF.top = Y - radius;
        rectF.right = X + radius;
        rectF.bottom = Y +  radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(titleStr,(mWidth/2)+getPaddingLeft()+getPaddingRight() - textRect.width()/2,getMeasuredHeight()-textRect.height(),titlePaint);
        paintPie(canvas);
    }

    private void paintPie(Canvas canvas){
        if(map != null){
            Set<Map.Entry<String,Float>> entries = map.entrySet();
            Iterator<Map.Entry<String,Float>> iter = entries.iterator();
            float currentAngle = 0;
            int i = 0;
            while (iter.hasNext()){
                Map.Entry<String,Float> entry = iter.next();
                float needAngle = 360 * entry.getValue();
                if(Math.min(needAngle,animatedValue*360 - currentAngle) >= 0){
                    doPaint.setColor(colors[i%colors.length]);
                    canvas.drawArc(rectF,currentAngle,Math.min(needAngle,animatedValue*360 - currentAngle),true,doPaint);
                }
                currentAngle+=needAngle;
                i++;
            }
        }
    }

    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

    protected int sp2px(int spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, getResources().getDisplayMetrics());

    }
}
