package com.cubetiqs.common.utils.number

import java.math.RoundingMode
import java.text.DecimalFormat

fun Number.toStringDecimal(pattern: String = "#.##"): String {
    return DecimalFormat(pattern).format(this)
}

fun Number.toDecimalPrecision(precision: Int? = 2, roundingMode: RoundingMode = RoundingMode.HALF_EVEN): String {
    var pattern = "##0"
    if (precision ?: 0 > 0) {
        pattern += "."
    }
    repeat(precision ?: 2) {
        pattern += "0"
    }
    val df = DecimalFormat(pattern)
    df.roundingMode = roundingMode
    return df.format(this)
}