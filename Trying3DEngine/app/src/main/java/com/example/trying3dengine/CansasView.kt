package com.example.trying3dengine

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View


class CansasView : View {
    private val mPath: Path = Path()
    private var mWidth = 0
    private var mHeight = 0
    val paint = Paint().apply {
        color = Color.BLACK
        // Smooths out edges of what is drawn without affecting shape.
        isAntiAlias = true
        // Dithering affects how colors with higher-precision than the device are down-sampled.
        isDither = true
        style = Paint.Style.STROKE // default: FILL
        strokeJoin = Paint.Join.ROUND // default: MITER
        strokeCap = Paint.Cap.ROUND // default: BUTT
        strokeWidth = 12f // default: Hairline-width (really thin)
    }


    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attribs: AttributeSet?) : super(
        context,
        attribs
    ) {
    }

    private fun initSquare(){
        s.add(
            Square(
                Vertex(-500f, -500f, 500f),
                Vertex(500f, -500f, 500f),
                Vertex(500f, 500f, 500f),
                Vertex(-500f, 500f, 500f),
                Vertex(0f, 0f, 500f)
            )
        )
        s.add(
            Square(
                Vertex(-500f, -500f, -500f),
                Vertex(500f, -500f, -500f),
                Vertex(500f, -500f, 500f),
                Vertex(-500f, -500f, 500f),
                Vertex(0f, -500f, 0f)
            )
        )
        s.add(
            Square(
                Vertex(-500f, 500f, 500f),
                Vertex(-500f, 500f, -500f),
                Vertex(500f, 500f, -500f),
                Vertex(500f, 500f, 500f),
                Vertex(0f, 500f, 0f)
            )
        )
        s.add(
            Square(
                Vertex(500f, -500f, 500f),
                Vertex(500f, -500f, -500f),
                Vertex(500f, 500f, -500f),
                Vertex(500f, 500f, 500f),
                Vertex(500f, 0f, 0f)
            )
        )
        s.add(
            Square(
                Vertex(-500f, -500f, -500f),
                Vertex(-500f, -500f, 500f),
                Vertex(-500f, 500f, 500f),
                Vertex(-500f, 500f, -500f),
                Vertex(-500f, 0f, 0f)
            )
        )
        s.add(
            Square(
                Vertex(-500f, -500f, -500f),
                Vertex(500f, -500f, -500f),
                Vertex(500f, 500f, -500f),
                Vertex(-500f, 500f, -500f),
                Vertex(0f, 0f, -500f)
            )
        )
    }

    private fun initNums(){
        nums.add(
            Numbers(
                Vertex(0f, 300f, -500f),
                Vertex(0f, -300f, -500f),
                Vertex(-100f, 300f, -500f),
                Vertex(100f, 300f, -500f),
                Vertex(-100f, -300f, -500f),
                Vertex(100f, -300f, -500f)
            )
        )
    }

    override fun onDraw(canvas: Canvas) {
        if(s.size == 0){
            initSquare()
            initNums()
        }

        var d = mWidth / 2

        if(s[5].centre.z <= s[0].centre.z){
            canvas.drawLine(s[5].v1.x + d, s[5].v1.y + d, s[5].v2.x + d, s[5].v2.y + d, paint)
            canvas.drawLine(s[5].v2.x + d, s[5].v2.y + d, s[5].v3.x + d, s[5].v3.y + d, paint)
            canvas.drawLine(s[5].v3.x + d, s[5].v3.y + d, s[5].v4.x + d, s[5].v4.y + d, paint)
            canvas.drawLine(s[5].v4.x + d, s[5].v4.y + d, s[5].v1.x + d, s[5].v1.y + d, paint)

            canvas.drawLine(nums[0].v1.x + d, nums[0].v1.y + d, nums[0].v2.x + d, nums[0].v2.y + d, paint)
            canvas.drawLine(nums[0].v3.x + d, nums[0].v3.y + d, nums[0].v4.x + d, nums[0].v4.y + d, paint)
            canvas.drawLine(nums[0].v5.x + d, nums[0].v5.y + d, nums[0].v6.x + d, nums[0].v6.y + d, paint)
        }
        else{
            canvas.drawLine(s[0].v1.x + d, s[0].v1.y + d, s[0].v2.x + d, s[0].v2.y + d, paint)
            canvas.drawLine(s[0].v2.x + d, s[0].v2.y + d, s[0].v3.x + d, s[0].v3.y + d, paint)
            canvas.drawLine(s[0].v3.x + d, s[0].v3.y + d, s[0].v4.x + d, s[0].v4.y + d, paint)
            canvas.drawLine(s[0].v4.x + d, s[0].v4.y + d, s[0].v1.x + d, s[0].v1.y + d, paint)
        }

        if(s[1].centre.z <= s[2].centre.z){
            canvas.drawLine(s[1].v1.x + d, s[1].v1.y + d, s[1].v2.x + d, s[1].v2.y + d, paint)
            canvas.drawLine(s[1].v2.x + d, s[1].v2.y + d, s[1].v3.x + d, s[1].v3.y + d, paint)
            canvas.drawLine(s[1].v3.x + d, s[1].v3.y + d, s[1].v4.x + d, s[1].v4.y + d, paint)
            canvas.drawLine(s[1].v4.x + d, s[1].v4.y + d, s[1].v1.x + d, s[1].v1.y + d, paint)
        }
        else{
            canvas.drawLine(s[2].v1.x + d, s[2].v1.y + d, s[2].v2.x + d, s[2].v2.y + d, paint)
            canvas.drawLine(s[2].v2.x + d, s[2].v2.y + d, s[2].v3.x + d, s[2].v3.y + d, paint)
            canvas.drawLine(s[2].v3.x + d, s[2].v3.y + d, s[2].v4.x + d, s[2].v4.y + d, paint)
            canvas.drawLine(s[2].v4.x + d, s[2].v4.y + d, s[2].v1.x + d, s[2].v1.y + d, paint)
        }

        if(s[3].centre.z <= s[4].centre.z){
            canvas.drawLine(s[3].v1.x + d, s[3].v1.y + d, s[3].v2.x + d, s[3].v2.y + d, paint)
            canvas.drawLine(s[3].v2.x + d, s[3].v2.y + d, s[3].v3.x + d, s[3].v3.y + d, paint)
            canvas.drawLine(s[3].v3.x + d, s[3].v3.y + d, s[3].v4.x + d, s[3].v4.y + d, paint)
            canvas.drawLine(s[3].v4.x + d, s[3].v4.y + d, s[3].v1.x + d, s[3].v1.y + d, paint)
        }
        else{
            canvas.drawLine(s[4].v1.x + d, s[4].v1.y + d, s[4].v2.x + d, s[4].v2.y + d, paint)
            canvas.drawLine(s[4].v2.x + d, s[4].v2.y + d, s[4].v3.x + d, s[4].v3.y + d, paint)
            canvas.drawLine(s[4].v3.x + d, s[4].v3.y + d, s[4].v4.x + d, s[4].v4.y + d, paint)
            canvas.drawLine(s[4].v4.x + d, s[4].v4.y + d, s[4].v1.x + d, s[4].v1.y + d, paint)
        }

        /*
        for(i in 0 until s.size) {
            canvas.drawLine(s[i].v1.x + d, s[i].v1.y + d, s[i].v2.x + d, s[i].v2.y + d, paint)
            canvas.drawLine(s[i].v2.x + d, s[i].v2.y + d, s[i].v3.x + d, s[i].v3.y + d, paint)
            canvas.drawLine(s[i].v3.x + d, s[i].v3.y + d, s[i].v4.x + d, s[i].v4.y + d, paint)
            canvas.drawLine(s[i].v4.x + d, s[i].v4.y + d, s[i].v1.x + d, s[i].v1.y + d, paint)

        }

         */

        //canvas.drawPath(mPath, paint)
        canvas.save()
        super.onDraw(canvas)
    }

    fun draw(){
        invalidate()
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        mWidth = MeasureSpec.getSize(widthMeasureSpec)
        mHeight = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(mWidth, mHeight)
    }
}


