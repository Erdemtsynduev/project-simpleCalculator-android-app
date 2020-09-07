package com.erdemtsynduev.simplecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import com.erdemtsynduev.simplecalculator.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import soup.neumorphism.NeumorphButton
import soup.neumorphism.ShapeType

class MainActivity : AppCompatActivity(), View.OnTouchListener, Calculator {

    lateinit var calculatorImpl: CalculatorImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculatorImpl = CalculatorImpl(this, applicationContext)

        button_clear.setOnTouchListener(this)
        button_plus_minus.setOnTouchListener(this)
        button_percent.setOnTouchListener(this)
        button_division.setOnTouchListener(this)

        button_seven.setOnTouchListener(this)
        button_eight.setOnTouchListener(this)
        button_nine.setOnTouchListener(this)
        button_multiply.setOnTouchListener(this)

        button_four.setOnTouchListener(this)
        button_five.setOnTouchListener(this)
        button_six.setOnTouchListener(this)
        button_minus.setOnTouchListener(this)

        button_one.setOnTouchListener(this)
        button_two.setOnTouchListener(this)
        button_three.setOnTouchListener(this)
        button_plus.setOnTouchListener(this)

        button_zero.setOnTouchListener(this)
        button_comma.setOnTouchListener(this)
        button_equally.setOnTouchListener(this)


        button_plus.setOnClickListener { calculatorImpl.handleOperation(PLUS) }
        button_minus.setOnClickListener { calculatorImpl.handleOperation(MINUS) }
        button_multiply.setOnClickListener { calculatorImpl.handleOperation(MULTIPLY) }
        button_division.setOnClickListener { calculatorImpl.handleOperation(DIVIDE) }
        button_percent.setOnClickListener { calculatorImpl.handleOperation(PERCENT) }
        button_plus_minus.setOnClickListener { calculatorImpl.handleOperation(PLUS_MINUS) }

        button_clear.setOnClickListener { calculatorImpl.handleClear(); }
        button_clear.setOnLongClickListener { calculatorImpl.handleReset(); true }

        getButtonIds().forEach { it ->
            it.setOnClickListener { calculatorImpl.numpadClicked(it.id) }
        }

        button_equally.setOnClickListener { calculatorImpl.handleEquals() }
    }

    private fun getButtonIds() = arrayOf(
        button_comma,
        button_zero,
        button_one,
        button_two,
        button_three,
        button_four,
        button_five,
        button_six,
        button_seven,
        button_eight,
        button_nine
    )

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        when (p1?.action) {
            MotionEvent.ACTION_DOWN -> {
                val button: NeumorphButton = p0 as NeumorphButton
                button.setShapeType(ShapeType.PRESSED)
            }
            MotionEvent.ACTION_UP -> {
                p0?.performClick()
                val button: NeumorphButton = p0 as NeumorphButton
                button.setShapeType(ShapeType.FLAT)
            }
        }
        return true
    }

    override fun setValue(value: String, context: Context) {
        result.text = value
    }

    override fun setValueDouble(d: Double) {
        calculatorImpl.setValue(Formatter.doubleToString(d))
        calculatorImpl.lastKey = DIGIT
    }

    override fun setFormula(value: String, context: Context) {
        formula.text = value
    }
}