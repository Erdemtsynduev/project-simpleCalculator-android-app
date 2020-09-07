package com.erdemtsynduev.simplecalculator.operation

import com.erdemtsynduev.simplecalculator.operation.base.BinaryOperation
import com.erdemtsynduev.simplecalculator.operation.base.Operation
import kotlin.math.pow

class PowerOperation(baseValue: Double, secondValue: Double) : BinaryOperation(baseValue, secondValue),
    Operation {

    override fun getResult(): Double {
        var result = baseValue.pow(secondValue)
        if (java.lang.Double.isInfinite(result) || java.lang.Double.isNaN(result))
            result = 0.0
        return result
    }
}
