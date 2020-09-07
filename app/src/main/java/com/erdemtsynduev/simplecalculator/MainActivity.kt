package com.erdemtsynduev.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import soup.neumorphism.ShapeType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_clear.setOnTouchListener(View.OnTouchListener { view, motionEvent ->
            when (motionEvent.action){
                MotionEvent.ACTION_DOWN -> {
                    button_clear.setShapeType(ShapeType.PRESSED)
                }
                MotionEvent.ACTION_UP -> {
                    view.performClick()
                    button_clear.setShapeType(ShapeType.FLAT)
                }
            }
            return@OnTouchListener true
        })
    }
}