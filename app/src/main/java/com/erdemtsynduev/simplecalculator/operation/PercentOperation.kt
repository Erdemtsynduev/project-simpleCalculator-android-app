package com.erdemtsynduev.simplecalculator.operation

import com.erdemtsynduev.simplecalculator.operation.base.BinaryOperation
import com.erdemtsynduev.simplecalculator.operation.base.Operation

class PercentOperation(baseValue: Double, secondValue: Double) : BinaryOperation(baseValue, secondValue),
    Operation {

    override fun getResult(): Double {
        var result = 0.0
        if (secondValue != 0.0) {
            result = baseValue / 100 * secondValue
        }
        return result
    }
}
