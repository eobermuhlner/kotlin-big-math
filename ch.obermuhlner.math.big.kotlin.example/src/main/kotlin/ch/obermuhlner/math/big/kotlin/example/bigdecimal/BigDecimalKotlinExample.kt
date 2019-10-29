package ch.obermuhlner.math.big.kotlin.example.bigdecimal

import java.math.BigDecimal
import java.math.BigDecimal.*
import ch.obermuhlner.math.big.DefaultBigDecimalMath.*
import ch.obermuhlner.math.big.kotlin.bigdecimal.*

fun main(args: Array<String>) {
	simpleExample()
	createLocalMathContextExample()
	withLocalMathContextExample()
	piChudnovskyExample()
}

fun simpleExample() {
	val v1 = valueOf(2) / 3

	println(v1)
}

fun createLocalMathContextExample() {
	println("Pi[default]: " + pi())

	createLocalMathContext(5).use {
		println("Pi[5]: " + pi())

		createLocalMathContext(10).use {
			println("Pi[10]: " + pi())
		}

		println("Pi[5]: " + pi())
	}

	println("Pi[default]: " + pi())
}

fun withLocalMathContextExample() {
	println("Pi[default]: " + pi())

	withLocalMathContext(5) {
		println("Pi[5]: " + pi())

		withLocalMathContext(10) {
			println("Pi[10]: " + pi())
		}

		println("Pi[5]: " + pi())
	}

	println("Pi[default]: " + pi())
}

fun piChudnovskyExample() {
	withLocalMathContext(100) {
		println(piChudnovsky())
	}
}

fun piChudnovsky() : BigDecimal {
	val valueDivisor = (valueOf(640320) pow 3) / 24

	var sumA = valueOf(1)
	var sumB = valueOf(0)

	var a = valueOf(1)
	var dividendTerm1 = valueOf(5) // -(6*k - 5)
	var dividendTerm2 = valueOf(-1) // 2*k - 1
	var dividendTerm3 = valueOf(-1) // 6*k - 1

	val precision = currentMathContext().precision
	val iterationCount = (precision+13) / 14 + 1
	for (k in 1 .. iterationCount) {
		dividendTerm1 += -6
		dividendTerm2 += 2
		dividendTerm3 += 6
		
		val dividend = dividendTerm1 * dividendTerm2 * dividendTerm3
		val divisor = (valueOf(k) pow 3) * valueDivisor
		a *= dividend / divisor
		val b = a * k
		
		sumA += a
		sumB += b
	}
	
	val factor = sqrt(valueOf(10005)) * 426880;
	val pi = factor / (sumA * 13591409 + sumB * 545140134);
	
	return pi;
}
