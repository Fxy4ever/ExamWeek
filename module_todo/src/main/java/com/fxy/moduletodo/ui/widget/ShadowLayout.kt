package com.fxy.moduletodo.ui.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import com.fxy.moduletodo.R
import com.fxy.moduletodo.util.*
import com.fxy.moduletodo.util.containsFlag
import com.fxy.moduletodo.util.createPaint
import com.fxy.moduletodo.util.dp2px
import com.fxy.moduletodo.util.helpGreenCurtain
import kotlin.math.absoluteValue
import kotlin.properties.Delegates

class ShadowLayout @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    companion object {
        const val debug = false

        private const val FLAG_SIDES_TOP = 1
        private const val FLAG_SIDES_RIGHT = 2
        private const val FLAG_SIDES_BOTTOM = 4
        private const val FLAG_SIDES_LEFT = 8
        private const val FLAG_SIDES_ALL = 15

        const val default_shadowColor = Color.WHITE
        const val default_shadowRadius = 0f
        const val default_dx = 0f
        const val default_dy = 0f
        const val default_cornerRadius = 0f
        const val default_borderColor = Color.BLACK
        const val default_borderWidth = 0f
        const val default_shadowSides = FLAG_SIDES_ALL
    }

    @ColorInt
    private var mShadowColor: Int = 0

    //阴影发散距离
    private var mShadowRadius: Float = 0f

    //偏移量
    private var mDx: Float = 0f

    private var mDy: Float = 0f

    private var mCornerRadius: Float = 0f

    @ColorInt
    private var mBorderColor: Int = 0

    private var mBorderWidth: Float = 0f

    private var mShadowSides: Int = default_shadowSides

    //全局画笔
    private var mPaint: Paint = createPaint(color = Color.WHITE)

    //全局Path
    private var mPath = Path()
    //合成模式
    private var mXfermode:  PorterDuffXfermode by Delegates.notNull()
    //视图内容区域的RectF实例
    private var mContentRectF: RectF by Delegates.notNull()
    //视图边框的RectF实例
    private var mBorderRectF: RectF? = null

    init {
        initAttr(context,attrs)
        initDrawAttr()
        processPadding()
        setLayerType(View.LAYER_TYPE_SOFTWARE,null)//开启软件渲染
    }

    private fun initAttr(context: Context, attrs: AttributeSet?) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.ShadowLayout)
        a?.run {
            mShadowColor = getColor(R.styleable.ShadowLayout_shadowColor, default_shadowColor)
            mShadowRadius =
                    getDimension(R.styleable.ShadowLayout_shadowRadius, context.dp2px(default_shadowRadius))
            mDx = getDimension(R.styleable.ShadowLayout_shadowWidth, default_dx)
            mDy = getDimension(R.styleable.ShadowLayout_shadowHeight, default_dy)

            mCornerRadius =
                    getDimension(R.styleable.ShadowLayout_cornerRadius, context.dp2px(default_cornerRadius))
            mBorderColor = getColor(R.styleable.ShadowLayout_borderColor, default_borderColor)
            mBorderWidth =
                    getDimension(R.styleable.ShadowLayout_borderWidth, context.dp2px(default_borderWidth))

            mShadowSides = getInt(R.styleable.ShadowLayout_shadowSides, default_shadowSides)
        }
        a?.recycle()
    }

    private fun initDrawAttr(){
        //使用此，在图层上进行合成，处理圆角
        mXfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
    }

    private fun processPadding(){
        val xPadding = (mShadowRadius + mDx.absoluteValue).toInt()
        val yPadding = (mShadowRadius + mDy.absoluteValue).toInt()

        setPadding(
                if (mShadowSides.containsFlag(FLAG_SIDES_LEFT)) xPadding else 0,
                if (mShadowSides.containsFlag(FLAG_SIDES_TOP)) yPadding else 0,
                if (mShadowSides.containsFlag(FLAG_SIDES_RIGHT)) xPadding else 0,
                if (mShadowSides.containsFlag(FLAG_SIDES_BOTTOM)) yPadding else 0
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mContentRectF = RectF(
                paddingLeft.toFloat(),
                paddingTop.toFloat(),
                (w - paddingRight).toFloat(),
                (h - paddingBottom).toFloat()
        )

        val borderWidth = mBorderWidth / 4
        if(borderWidth > 0){
            mBorderRectF = RectF(
                    mContentRectF.left + borderWidth,
                    mContentRectF.top + borderWidth,
                    mContentRectF.right - borderWidth,
                    mContentRectF.bottom - borderWidth
            )
        }
    }

    override fun dispatchDraw(canvas: Canvas?) {
        if(canvas == null) return

        canvas.helpGreenCurtain(debug)
        //绘制阴影
        drawShadow(canvas)

        //绘制子View
        drawChild(canvas){
            super.dispatchDraw(it)
        }

        drawBorder(canvas)
    }

    private fun drawShadow(canvas: Canvas) {
        canvas.save()

        mPaint.setShadowLayer(mShadowRadius, mDx, mDy, mShadowColor)
        canvas.drawRoundRect(mContentRectF, mCornerRadius, mCornerRadius, mPaint)
        mPaint.utilReset()

        canvas.restore()
    }


    private fun drawChild(canvas: Canvas,block: (Canvas) -> Unit){
        canvas.saveLayer(0f,0f,
                canvas.width.toFloat(),canvas.height.toFloat(),
                mPaint,Canvas.ALL_SAVE_FLAG)
        block.invoke(canvas)
        mPath = mPath.apply {
            addRect(
                    mContentRectF,
                    Path.Direction.CW
            )

            addRoundRect(
                    mContentRectF,
                    mCornerRadius,
                    mCornerRadius,
                    Path.Direction.CW
            )

            fillType = Path.FillType.EVEN_ODD
        }

        //利用xFerMode在图层上进行合成，处理圆角
        mPaint.xfermode = mXfermode
        canvas.drawPath(mPath,mPaint)
        mPaint.utilReset()
        mPath.reset()

        canvas.restore()
    }

    private fun drawBorder(canvas: Canvas) {
        mBorderRectF?.let {
            canvas.save()

            mPaint.strokeWidth = mBorderWidth
            mPaint.style = Paint.Style.STROKE
            mPaint.color = mBorderColor
            canvas.drawRoundRect(it, mCornerRadius, mCornerRadius, mPaint)
            mPaint.utilReset()

            canvas.restore()
        }
    }

}