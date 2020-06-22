package ch.obermuhlner.math.big.kotlin.example.bigdecimal

import java.math.BigDecimal
import java.math.BigDecimal.*
import java.math.MathContext

fun main(args: Array<String>) {
    standardValueOfExample()
    standardPrecisionExample()
}

fun standardValueOfExample() {
    val n = 2
    //val v = valueOf(n)
    // Compile Error: None of the following functions can be called with the arguments supplied.
    //   valueOf(Double) defined in java.math.BigDecimal
    //   valueOf(Long) defined in java.math.BigDecimal
}

fun standardPrecisionExample() {
    val v1 = valueOf(2) + valueOf(3)
    println(v1) // prints: 5

    val v2 = valueOf(2) / valueOf(3)
    println(v2) // prints: 1

    var v3 = valueOf(0.123456)
    for (i in 0..20) {
        v3 = v3 * valueOf(0.345678)
        println(v3)
    }
}


fun standardPrimitiveTypesWithOperatorsExample() {
    val v1 = valueOf(2)
    val v2 = v1 * valueOf(3)
    val v3 = valueOf(4) * v1

    //val v4 = v1 * 2
    // Compile Error: The integer literal does not conform to the expected type BigDecimal
}
