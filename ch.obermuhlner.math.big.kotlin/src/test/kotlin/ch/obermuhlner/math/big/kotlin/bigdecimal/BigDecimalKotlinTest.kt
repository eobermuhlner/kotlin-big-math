package ch.obermuhlner.math.big.kotlin.bigdecimal

import org.junit.Test
import org.junit.Assert.assertEquals

import ch.obermuhlner.math.big.DefaultBigDecimalMath.*
import ch.obermuhlner.math.big.kotlin.bigdecimal.*
import java.math.BigDecimal

class BigDecimalKotlinTest {
	
	@Test
	fun testOperatorPlus() {
		assertEquals(BigDecimal.valueOf(5), BigDecimal.valueOf(2) + 3)
		assertEquals(BigDecimal.valueOf(5), BigDecimal.valueOf(2) + 3L)
		assertEquals(BigDecimal.valueOf(5.0), BigDecimal.valueOf(2) + 3.0)
		assertEquals(BigDecimal.valueOf(5.0), BigDecimal.valueOf(2) + BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(5), BigDecimal.valueOf(2) + BigDecimal.valueOf(3))
	}
	
	@Test
	fun testOperatorMinus() {
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(5) - 3)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(5) - 3L)
		assertEquals(BigDecimal.valueOf(2.0), BigDecimal.valueOf(5) - 3.0)
		assertEquals(BigDecimal.valueOf(2.0), BigDecimal.valueOf(5) - BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(5) - BigDecimal.valueOf(3))
	}

	@Test
	fun testOperatorTimes() {
		assertEquals(BigDecimal.valueOf(6), BigDecimal.valueOf(2) * 3)
		assertEquals(BigDecimal.valueOf(6), BigDecimal.valueOf(2) * 3L)
		assertEquals(BigDecimal.valueOf(6.0), BigDecimal.valueOf(2) * 3.0)
		assertEquals(BigDecimal.valueOf(6.0), BigDecimal.valueOf(2) * BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(6), BigDecimal.valueOf(2) * BigDecimal.valueOf(3))
	}

	@Test
	fun testOperatorDiv() {
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(6) / 3)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(6) / 3L)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(6) / 3.0)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(6) / BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(6) / BigDecimal.valueOf(3))
		
		assertEquals(BigDecimal.valueOf(0.125), BigDecimal.valueOf(1) / 8)
		assertEquals(BigDecimal.valueOf(0.125), BigDecimal.valueOf(1) / 8L)
		assertEquals(BigDecimal.valueOf(0.125), BigDecimal.valueOf(1) / 8.0)
		assertEquals(BigDecimal.valueOf(0.125), BigDecimal.valueOf(1) / BigDecimal.valueOf(8.0))
		assertEquals(BigDecimal.valueOf(0.125), BigDecimal.valueOf(1) / BigDecimal.valueOf(8))
	}

	@Test
	fun testOperatorUnaryMinus() {
		assertEquals(BigDecimal.valueOf(-5), - BigDecimal.valueOf(5))
	}

	@Test
	fun testInfixPow() {
		assertEquals(BigDecimal.valueOf(8), BigDecimal.valueOf(2) pow 3)
		assertEquals(BigDecimal.valueOf(8), BigDecimal.valueOf(2) pow 3L)
		assertEquals(BigDecimal.valueOf(8), BigDecimal.valueOf(2) pow 3.0)
		assertEquals(BigDecimal.valueOf(8), BigDecimal.valueOf(2) pow BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(8), BigDecimal.valueOf(2) pow BigDecimal.valueOf(3))
	}

	@Test
	fun testInfixRoot() {
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(8) root 3)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(8) root 3L)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(8) root 3.0)
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(8) root BigDecimal.valueOf(3.0))
		assertEquals(BigDecimal.valueOf(2), BigDecimal.valueOf(8) root BigDecimal.valueOf(3))
	}

	@Test
	fun testOperatorInc() {
		var v1 = BigDecimal.valueOf(5)
		assertEquals(BigDecimal.valueOf(5), v1++)
		assertEquals(BigDecimal.valueOf(6), v1)
		
		v1 = BigDecimal.valueOf(5)
		assertEquals(BigDecimal.valueOf(6), ++v1)
		assertEquals(BigDecimal.valueOf(6), v1)
	}

	@Test
	fun testOperatorDec() {
		var v1 = BigDecimal.valueOf(5)
		assertEquals(BigDecimal.valueOf(5), v1--)
		assertEquals(BigDecimal.valueOf(4), v1)
		
		v1 = BigDecimal.valueOf(5)
		assertEquals(BigDecimal.valueOf(4), --v1)
		assertEquals(BigDecimal.valueOf(4), v1)
	}

	@Test
	fun withPrecision() {
		assertEquals(getDefaultMathContext(), currentMathContext())

		withLocalMathContext(5) {
			assertEquals(5, currentMathContext().precision)
			assertEquals(BigDecimal.valueOf(3.1416), pi())

			withLocalMathContext(4) {
				assertEquals(4, currentMathContext().precision)
				assertEquals(BigDecimal.valueOf(3.142), pi())
			}

			assertEquals(5, currentMathContext().precision)
			assertEquals(BigDecimal.valueOf(3.1416), pi())
		}

		assertEquals(getDefaultMathContext(), currentMathContext())
    }
}
