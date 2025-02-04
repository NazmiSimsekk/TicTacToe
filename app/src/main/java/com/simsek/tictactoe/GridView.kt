package com.simsek.tictactoe

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GridView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.WHITE
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val cellWidth = width / 3
        val cellHeight = height / 3

        // Dikey çizgileri çiz
        for (i in 1 until 3) {
            canvas.drawLine(i * cellWidth.toFloat(), 0f, i * cellWidth.toFloat(), height.toFloat(), paint)
        }

        // Yatay çizgileri çiz
        for (i in 1 until 3) {
            canvas.drawLine(0f, i * cellHeight.toFloat(), width.toFloat(), i * cellHeight.toFloat(), paint)
        }

        // Dış kenarlıkları çiz
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }
}