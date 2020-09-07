package com.erdemtsynduev.simplecalculator.operation

import com.erdemtsynduev.simplecalculator.operation.base.Operation
import com.erdemtsynduev.simplecalculator.operation.base.UnaryOperation
import kotlin.math.sqrt

class RootOperation(value: Double) : UnaryOperation(value), Operation {

    override fun getResult() = sqrt(value)
}
