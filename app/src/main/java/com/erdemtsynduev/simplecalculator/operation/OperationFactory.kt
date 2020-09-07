package com.erdemtsynduev.simplecalculator.operation

import com.erdemtsynduev.simplecalculator.operation.base.Operation
import com.erdemtsynduev.simplecalculator.utils.*

object OperationFactory {

    fun forId(id: String, baseValue: Double, secondValue: Double): Operation? {
        return when (id) {
            PLUS -> PlusOperation(baseValue, secondValue)
            MINUS -> MinusOperation(baseValue, secondValue)
            DIVIDE -> DivideOperation(baseValue, secondValue)
            MULTIPLY -> MultiplyOperation(baseValue, secondValue)
            PERCENT -> PercentOperation(baseValue, secondValue)
            POWER -> PowerOperation(baseValue, secondValue)
            ROOT -> RootOperation(baseValue)
            FACTORIAL -> FactorialOperation(baseValue)
            else -> null
        }
    }
}
