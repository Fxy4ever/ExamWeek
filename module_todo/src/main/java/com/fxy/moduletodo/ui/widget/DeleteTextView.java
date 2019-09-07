package com.fxy.moduletodo.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class DeleteTextView extends View {
    private boolean isDelete = false;
    private Paint deleteLine;
    private Paint mPaint;
    private int normalColor = Color.BLACK;
    private int deleteColor = Color.GRAY;
    private String mTextStr = "";
    private int mWidth = 100;//默认
    private int mHeight = 100;
    private Rect rect;


    public DeleteTextView(Context context) {
        super(context);
        init();
    }

    public DeleteTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DeleteTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init(){
        deleteLine = new Paint();
        mPaint = new Paint();
        mPaint.setTextSize(50);
        rect = new Rect();
        setPadding(8,4,8,4);
    }

    public String getmTextStr() {
        return mTextStr;
    }

    public void setmTextStr(String mTextStr) {
        this.mTextStr = mTextStr;
        init();
        invalidate();
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
        init();
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        mPaint.getTextBounds(mTextStr,0,mTextStr.length(),rect);
        mWidth = rect.width();
        mHeight = rect.height();

        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth+getPaddingLeft()+getPaddingRight(), mHeight+getPaddingBottom()+getPaddingTop());
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(mWidth+getPaddingLeft()+getPaddingRight(), heightSize);
        } else if (getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            setMeasuredDimension(widthSize, mHeight+getPaddingBottom()+getPaddingTop());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        deleteLine.setColor(isDelete ? deleteColor : normalColor);
        deleteLine.setStrokeWidth(3f);

        mPaint.setColor(isDelete ? deleteColor : normalColor);

        if(isDelete){
            canvas.drawLine(0,
                    mHeight/2,
                    getMeasuredWidth(),
                    mHeight/2,
                    deleteLine);
            canvas.drawText(mTextStr,0,mHeight,mPaint);
        }else{
            canvas.drawText(mTextStr,0,mHeight,mPaint);
        }
    }
}
