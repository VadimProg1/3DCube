package com.example.trying3dengine

import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


var s: MutableList<Square> = ArrayList()
var nums: MutableList<Numbers> = ArrayList()

class MainActivity : AppCompatActivity() {

    var prevRZ = 0
    var prevRY = 0
    var prevRX = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        seekBarZ.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val heading = Math.toRadians(seekBar!!.progress.toDouble() - prevRZ)
                val transform = Matrix3(
                    doubleArrayOf(
                        Math.cos(heading), 0.0, -Math.sin(heading),
                        0.0 , 1.0, 0.0,
                        Math.sin(heading), 0.0, Math.cos(heading)
                    )
                )
                for(i in 0 until s.size) {
                    s[i].v1 = transform.transform(s[i].v1)
                    s[i].v2 = transform.transform(s[i].v2)
                    s[i].v3 = transform.transform(s[i].v3)
                    s[i].v4 = transform.transform(s[i].v4)
                    s[i].centre = transform.transform(s[i].centre)
                }
                nums[0].v1 = transform.transform(nums[0].v1)
                nums[0].v2 = transform.transform(nums[0].v2)
                nums[0].v3 = transform.transform(nums[0].v3)
                nums[0].v4 = transform.transform(nums[0].v4)
                nums[0].v5 = transform.transform(nums[0].v5)
                nums[0].v6 = transform.transform(nums[0].v6)

                cans.draw()
                prevRZ = seekBar.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarY.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val heading = Math.toRadians(seekBar!!.progress.toDouble() - prevRY)
                val transform = Matrix3(
                    doubleArrayOf(
                        1.0, 0.0, 0.0,
                        0.0, Math.cos(heading), Math.sin(heading),
                        0.0, -Math.sin(heading), Math.cos(heading)
                    )
                )
                for(i in 0 until s.size) {
                    s[i].v1 = transform.transform(s[i].v1)
                    s[i].v2 = transform.transform(s[i].v2)
                    s[i].v3 = transform.transform(s[i].v3)
                    s[i].v4 = transform.transform(s[i].v4)
                    s[i].centre = transform.transform(s[i].centre)
                }
                nums[0].v1 = transform.transform(nums[0].v1)
                nums[0].v2 = transform.transform(nums[0].v2)
                nums[0].v3 = transform.transform(nums[0].v3)
                nums[0].v4 = transform.transform(nums[0].v4)
                nums[0].v5 = transform.transform(nums[0].v5)
                nums[0].v6 = transform.transform(nums[0].v6)
                cans.draw()
                prevRY = seekBar.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        seekBarX.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val heading = Math.toRadians(seekBar!!.progress.toDouble() - prevRX)
                val transform = Matrix3(
                    doubleArrayOf(
                        Math.cos(heading), -Math.sin(heading), 0.0,
                        Math.sin(heading), Math.cos(heading), 0.0,
                        0.0, 0.0, 1.0
                    )
                )
                for(i in 0 until s.size) {
                    s[i].v1 = transform.transform(s[i].v1)
                    s[i].v2 = transform.transform(s[i].v2)
                    s[i].v3 = transform.transform(s[i].v3)
                    s[i].v4 = transform.transform(s[i].v4)
                    s[i].centre = transform.transform(s[i].centre)
                }
                nums[0].v1 = transform.transform(nums[0].v1)
                nums[0].v2 = transform.transform(nums[0].v2)
                nums[0].v3 = transform.transform(nums[0].v3)
                nums[0].v4 = transform.transform(nums[0].v4)
                nums[0].v5 = transform.transform(nums[0].v5)
                nums[0].v6 = transform.transform(nums[0].v6)
                cans.draw()
                prevRX = seekBar.progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

    }

}

class Vertex(var x: Float, var y: Float, var z: Float)

class Square(
    var v1: Vertex,
    var v2: Vertex,
    var v3: Vertex,
    var v4: Vertex,
    var centre: Vertex
)

class Numbers(
    var v1: Vertex,
    var v2: Vertex,
    var v3: Vertex,
    var v4: Vertex,
    var v5: Vertex,
    var v6: Vertex
)

class Matrix3(var values: DoubleArray) {

    fun transform(`in`: Vertex): Vertex {
        return Vertex(
            (`in`.x * values[0] + `in`.y * values[3] + `in`.z * values[6]).toFloat(),
            (`in`.x * values[1] + `in`.y * values[4] + `in`.z * values[7]).toFloat(),
            (`in`.x * values[2] + `in`.y * values[5] + `in`.z * values[8]).toFloat()
        )
    }

}


