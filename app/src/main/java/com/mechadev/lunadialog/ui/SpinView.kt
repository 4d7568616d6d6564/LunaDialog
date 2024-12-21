package com.mechadev.lunadialog.ui

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import com.mechadev.lunadialog.R

class SpinView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : AppCompatImageView(context, attrs), Indeterminate {

    private var rotateDegrees = 0f
    private var frameTime = 1000 / 12
    private var needToUpdateView = false

    private val updateViewRunnable = object : Runnable {
        override fun run() {
            rotateDegrees += 30
            rotateDegrees = if (rotateDegrees < 360) rotateDegrees else rotateDegrees - 360
            invalidate()
            if (needToUpdateView) {
                postDelayed(this, frameTime.toLong())
            }
        }
    }

    init {
        setImageResource(R.drawable.drop_spinner)
    }

    override fun setAnimationSpeed(scale: Float) {
        frameTime = (1000 / 12 / scale).toInt()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.rotate(rotateDegrees, (width / 2).toFloat(), (height / 2).toFloat())
        super.onDraw(canvas)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        needToUpdateView = true
        post(updateViewRunnable)
    }

    override fun onDetachedFromWindow() {
        needToUpdateView = false
        super.onDetachedFromWindow()
    }
}
