package ch.obermuhlner.math.big.kotlin.bigdecimal

import ch.obermuhlner.math.big.DefaultBigDecimalMath
import java.math.BigDecimal

/**
 * Enables the use of the operator [BigDecimal] `+ BigDecimal`.
 */
operator fun BigDecimal.plus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.add(this, other)
/**
 * Enables the use of the operator [BigDecimal] `+ Double`.
 */
operator fun BigDecimal.plus(other: Double) : BigDecimal = DefaultBigDecimalMath.add(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `+ Long`.
 */
operator fun BigDecimal.plus(other: Long) : BigDecimal = DefaultBigDecimalMath.add(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `+` Int`.
 */
operator fun BigDecimal.plus(other: Int) : BigDecimal = DefaultBigDecimalMath.add(this, BigDecimal(other))
operator fun Double.plus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.add(BigDecimal.valueOf(this), other)
operator fun Long.plus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.add(BigDecimal.valueOf(this), other)
operator fun Int.plus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.add(BigDecimal(this), other)

/**
 * Enables the use of the operator [BigDecimal] `- BigDecimal`.
 */
operator fun BigDecimal.minus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.subtract(this, other)
/**
 * Enables the use of the operator [BigDecimal] `- Double`.
 */
operator fun BigDecimal.minus(other: Double) : BigDecimal = DefaultBigDecimalMath.subtract(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `- Long`.
 */
operator fun BigDecimal.minus(other: Long) : BigDecimal = DefaultBigDecimalMath.subtract(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `- Int`.
 */
operator fun BigDecimal.minus(other: Int) : BigDecimal = DefaultBigDecimalMath.subtract(this, BigDecimal(other))
operator fun Double.minus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.subtract(BigDecimal.valueOf(this), other)
operator fun Long.minus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.subtract(BigDecimal.valueOf(this), other)
operator fun Int.minus(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.subtract(BigDecimal(this), other)

/**
 * Enables the use of the operator [BigDecimal] `* BigDecimal`.
 */
operator fun BigDecimal.times(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.multiply(this, other)
/**
 * Enables the use of the operator [BigDecimal] `* BigDouble`.
 */
operator fun BigDecimal.times(other: Double) : BigDecimal = DefaultBigDecimalMath.multiply(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `* Long`.
 */
operator fun BigDecimal.times(other: Long) : BigDecimal = DefaultBigDecimalMath.multiply(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `* Int`.
 */
operator fun BigDecimal.times(other: Int) : BigDecimal = DefaultBigDecimalMath.multiply(this, BigDecimal(other))
operator fun Double.times(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.multiply(BigDecimal.valueOf(this), other)
operator fun Long.times(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.multiply(BigDecimal.valueOf(this), other)
operator fun Int.times(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.multiply(BigDecimal(this), other)

/**
 * Enables the use of the operator [BigDecimal] `/ BigDecimal`.
 */
operator fun BigDecimal.div(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.divide(this, other)
/**
 * Enables the use of the operator [BigDecimal] `/ Double`.
 */
operator fun BigDecimal.div(other: Double) : BigDecimal = DefaultBigDecimalMath.divide(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `/ Long`.
 */
operator fun BigDecimal.div(other: Long) : BigDecimal = DefaultBigDecimalMath.divide(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `/ Int`.
 */
operator fun BigDecimal.div(other: Int) : BigDecimal = DefaultBigDecimalMath.divide(this, BigDecimal(other))
operator fun Double.div(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.divide(BigDecimal.valueOf(this), other)
operator fun Long.div(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.divide(BigDecimal.valueOf(this), other)
operator fun Int.div(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.divide(BigDecimal(this), other)

/**
 * Enables the use of the operator [BigDecimal] `% BigDecimal`.
 */
operator fun BigDecimal.rem(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.remainder(this, other)
/**
 * Enables the use of the operator [BigDecimal] `% Double`.
 */
operator fun BigDecimal.rem(other: Double) : BigDecimal = DefaultBigDecimalMath.remainder(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `% Long`.
 */
operator fun BigDecimal.rem(other: Long) : BigDecimal = DefaultBigDecimalMath.remainder(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the operator [BigDecimal] `% Int`.
 */
operator fun BigDecimal.rem(other: Int) : BigDecimal = DefaultBigDecimalMath.remainder(this, BigDecimal(other))
operator fun Double.rem(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.remainder(BigDecimal.valueOf(this), other)
operator fun Long.rem(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.remainder(BigDecimal.valueOf(this), other)
operator fun Int.rem(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.remainder(BigDecimal(this), other)

/**
 * Enables the use of the operator `-`[BigDecimal].
 */
operator fun BigDecimal.unaryMinus() : BigDecimal = this.negate();

/**
 * Enables the use of the operator [BigDecimal] `++`.
 */
operator fun BigDecimal.inc() : BigDecimal = DefaultBigDecimalMath.add(this, BigDecimal.ONE)

/**
 * Enables the use of the operator [BigDecimal] `--`.
 */
operator fun BigDecimal.dec() : BigDecimal = DefaultBigDecimalMath.subtract(this, BigDecimal.ONE)

/**
 * Enables the use of the infix function [BigDecimal] `pow BigDecimal`.
 */
infix fun BigDecimal.pow(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.pow(this, other)
/**
 * Enables the use of the infix function [BigDecimal] `pow Double`.
 */
infix fun BigDecimal.pow(other: Double) : BigDecimal = DefaultBigDecimalMath.pow(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the infix function [BigDecimal] `pow Long`.
 */
infix fun BigDecimal.pow(other: Long) : BigDecimal = DefaultBigDecimalMath.pow(this, other)
/**
 * Enables the use of the infix function [BigDecimal] `pow Int`.
 */
infix fun BigDecimal.pow(other: Int) : BigDecimal = DefaultBigDecimalMath.pow(this, other.toLong())
infix fun Double.pow(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.pow(BigDecimal.valueOf(this), other)
infix fun Long.pow(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.pow(BigDecimal.valueOf(this), other)
infix fun Int.pow(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.pow(BigDecimal(this), other)

/**
 * Enables the use of the infix function [BigDecimal] `root BigDecimal`.
 */
infix fun BigDecimal.root(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.root(this, other)
/**
 * Enables the use of the infix function [BigDecimal] `root Double`.
 */
infix fun BigDecimal.root(other: Double) : BigDecimal = DefaultBigDecimalMath.root(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the infix function [BigDecimal] `root Long`.
 */
infix fun BigDecimal.root(other: Long) : BigDecimal = DefaultBigDecimalMath.root(this, BigDecimal.valueOf(other))
/**
 * Enables the use of the infix function [BigDecimal] `root Int`.
 */
infix fun BigDecimal.root(other: Int) : BigDecimal = DefaultBigDecimalMath.root(this, BigDecimal(other))
infix fun Double.root(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.root(BigDecimal.valueOf(this), other)
infix fun Long.root(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.root(BigDecimal.valueOf(this), other)
infix fun Int.root(other: BigDecimal) : BigDecimal = DefaultBigDecimalMath.root(BigDecimal(this), other)

fun valueOf(value: Int) : BigDecimal = BigDecimal(value)