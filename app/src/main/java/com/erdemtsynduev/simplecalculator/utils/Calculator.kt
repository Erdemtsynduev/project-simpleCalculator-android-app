package com.erdemtsynduev.simplecalculator.utils

import android.content.Context

interface Calculator {
    fun setValue(value: String, context: Context)

    fun setValueDouble(d: Double)

    fun setFormula(value: String, context: Context)
}
