package com.cubetiqs.common.utils.math

import com.cubetiqs.common.utils.number.toDecimalPrecision
import java.math.RoundingMode

/**
 * Math Float Round for Double.
 * Example: 9.999999 ... n => 10
 *          9.99 => 9.99
 */
fun Double?.fround(precision: Int = 5, roundingMode: RoundingMode = RoundingMode.HALF_DOWN): Double {
    if (this == null) return 0.0
    return this.toDecimalPrecision(precision, roundingMode).toDouble()
}

fun Number?.getPrecisionValue(): Double {
    if (this == null) return 0.0
    return ((this.toDouble()) - (this.toInt()).toDouble())
}