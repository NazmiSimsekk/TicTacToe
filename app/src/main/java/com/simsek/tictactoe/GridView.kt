package com.simsek.tictactoe

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class GridView(context: Context, attrs: AttributeSet) : View(context, attrs) {
    private val paint = Paint().apply {
        color = Color.parseColor("#673AB7")
        strokeWidth = 3f
        style = Paint.Style.STROKE
    }

    private val paintTwo = Paint().apply {
        color = Color.parseColor("#9575CD")
        strokeWidth = 3f
        style = Paint.Style.STROKE
    }

    private val winningLinePaint = Paint().apply {
        color = Color.parseColor("#FFEB3B")  // Kazanma çizgisi için parlak sarı
        strokeWidth = 6f  // Kalın çizgi
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
            canvas.drawLine(0f, i * cellHeight.toFloat(), width.toFloat(), i * cellHeight.toFloat(), paintTwo)
        }

        // Dış kenarlıkları çiz
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), paint)
    }

    // Kazanan çizgisi çizme fonksiyonu
    fun drawWinningLine(canvas: Canvas, startX: Float, startY: Float, endX: Float, endY: Float) {
        canvas.drawLine(startX, startY, endX, endY, winningLinePaint)
    }
}