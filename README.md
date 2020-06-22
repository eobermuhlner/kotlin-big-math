
[![Build Status](https://travis-ci.org/eobermuhlner/kotlin-big-math.svg?branch=master)](https://travis-ci.org/eobermuhlner/kotlin-big-math)
[![Maven Central](https://img.shields.io/maven-central/v/ch.obermuhlner/kotlin-big-math.svg)](https://search.maven.org/artifact/ch.obermuhlner/kotlin-big-math)

# kotlin-big-math
Kotlin library for BigDecimal math functions (pow, sqrt, log, sin, ...) using arbitrary precision.

## Introduction

This library depends on the [big-math](https://github.com/eobermuhlner/big-math) library
and provides additional Kotlin features to do calculations with arbitrary precision.

It provides two different approaches to do the calculations
- `BigDecimal` + `DefaultBigDecimalMath` : recommended approach
- `BigFloat` : experimental approach

The [big-math](https://github.com/eobermuhlner/big-math) library
provides advanced math functions (`pow`, `sqrt`, `log`, `sin`, ...).

The `kotlin-big-math` library enhances the `big-math` library with the kotlin specific operators and infix methods.
Additionally it solves several of the problems that the standard kotlib library has when using `BigDecimal`.
 

# BigDecimal + DefaultBigDecimalMath

By using the following imports you can use the standard `BigDecimal` class 
and the mathematical functions in `DefaultBigDecimalMath` in a simple but powerful manner:
```kotlin
import java.math.BigDecimal
import java.math.BigDecimal.*
import ch.obermuhlner.math.big.DefaultBigDecimalMath.*
import ch.obermuhlner.math.big.kotlin.bigdecimal.*
```

## BigDecimal Operators

* `+` operator
* `-` operator
* `*` operator
* `/` operator
* `%` operator


* `++` operator
* `--` operator


* `pow` infix method
* `root` infix method


* `valueOf(Int)` method (equivalent to `BigDecimal(Int)` constructor)

### Using BigDecimal + DefaultBigDecimalMath in Kotlin

The usage of `DefaultBigDecimalMath` follows the same rules as described in the [big-math](https://github.com/eobermuhlner/big-math#defaultbigdecimalmath) library.

To specify a temporary local `MathContext` you can either
use `createLocalMathContext()` method with `use`:
```kotlin
createLocalMathContext(10).use {
    // do some calculations using DefaultBigDecimalMath
}
```

Alternatively you can use the `withLocalMathContext()` method 
```kotlin
withLocalMathContext(10) {
    // do some calculations using DefaultBigDecimalMath
}
```

Full example:

```kotlin
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
```

This produces the following output:
```
0.6666666666666666666666666666666667
Pi[default]: 3.141592653589793238462643383279503
Pi[5]: 3.1416
Pi[10]: 3.141592654
Pi[5]: 3.1416
Pi[default]: 3.141592653589793238462643383279503
Pi[default]: 3.141592653589793238462643383279503
Pi[5]: 3.1416
Pi[10]: 3.141592654
Pi[5]: 3.1416
Pi[default]: 3.141592653589793238462643383279503
3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117069
```


# BigFloat

The `BigFloat` class is a wrapper around `BigDecimal` which simplifies the consistent usage of the `MathContext`
and provides a simpler API for calculations.

This is an experimental implementation.
Your mileage may vary.

Use the following imports:
```kotlin
import ch.obermuhlner.math.big.BigFloat
import ch.obermuhlner.math.big.BigFloat.*
import ch.obermuhlner.math.big.kotlin.bigfloat.*
```

## BigFloat Operators

* `+` operator
* `-` operator
* `*` operator
* `/` operator


* `++` operator
* `--` operator


* `pow` infix method
* `root` infix method

### Using BigFloat in Kotlin

The usage of `BigFloat` follows the same rules as described in the [big-math](https://github.com/eobermuhlner/big-math#bigfloat) library.

```kotlin
import ch.obermuhlner.math.big.BigFloat
import ch.obermuhlner.math.big.BigFloat.*
import ch.obermuhlner.math.big.kotlin.bigfloat.*

fun main(args: Array<String>) {
	simpleExample()
	piExample()
}

fun simpleExample() {
	val context = context(100)
	val v1 = context.valueOf(2) / 3

	println(v1)
}

fun piExample() {
	println(piChudnovsky(100))
}

fun piChudnovsky(precision: Int) : BigFloat {
	val context = context(precision + 10)
	
	val valueDivisor = (context.valueOf(640320) pow 3) / 24

	var sumA = context.valueOf(1)
	var sumB = context.valueOf(0)

	var a = context.valueOf(1)
	var dividendTerm1 = context.valueOf(5) // -(6*k - 5)
	var dividendTerm2 = context.valueOf(-1) // 2*k - 1
	var dividendTerm3 = context.valueOf(-1) // 6*k - 1
	
	val iterationCount = (context.getPrecision()+13) / 14 + 1
	for (k in 1 .. iterationCount) {
		dividendTerm1 += -6
		dividendTerm2 += 2
		dividendTerm3 += 6
		
		val dividend = dividendTerm1 * dividendTerm2 * dividendTerm3
		val divisor = (context.valueOf(k) pow 3) * valueDivisor
		a *= dividend / divisor
		val b = a * k
		
		sumA += a
		sumB += b
	}
	
	val factor = sqrt(context.valueOf(10005)) * 426880;
	val pi = factor / (sumA * 13591409 + sumB * 545140134);
	
	return context(precision).valueOf(pi);
}
```

This produces the following output:
```
0.6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666667
3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117068
```

## Comparison with standard kotlin library

The standard kotlin library already provides operators for `BigDecimal` but there are several problems with this solution.

### Standard Kotlin: Precision problem in division

The precision of the standard operators is determined from the arguments.
In the case of the division this can lead to unexpected results!

```kotlin
    // Code example with standard kotlin library (without kotlin-big-math)
    
    val v = valueOf(2) / valueOf(3)
    println(v) // prints: 1 !!!
```

This problem is solved in `kotlin-big-math` because the precision is specified outside the function call.
```kotlin
    // Code example with kotlin-big-math

    val v = valueOf(2) / valueOf(3)
    println(v) // prints: 0.6666666666666666666666666666666667
```

### Standard Kotlin: Missing `valueOf(Int)` function

The Java `BigDecimal` class has two overloaded `valueOf()` functions for the types `Double` and `Long` but not for `Int`. 
```kotlin
    // Code example with standard kotlin library (without kotlin-big-math)
    
    val n = 2
    val v0 = valueOf(n) // Compile Error!
```
This code does not compile but gives the following error:
```
Compile Error: None of the following functions can be called with the arguments supplied.
   valueOf(Double) defined in java.math.BigDecimal
   valueOf(Long) defined in java.math.BigDecimal
```

This problem is solved in `kotlin-big-math` by providing a `fun valueOf(Int): BigDecimal`.
```kotlin
    // Code example with kotlin-big-math

    val n = 2
    val v = valueOf(n)
```

### Standard Kotlin: Missing overloaded operators for Int, Double, Long
 
The standard kotlin library does not provide overloaded operators for mixing `Int`, `Double`, `Long` with `BigDecimal`.
This leads to unnecessary clutter:
```kotlin
    // Code example with standard kotlin library (without kotlin-big-math)
    
    val v1 = valueOf(2)
    val v2 = v1 * valueOf(3)
    val v3 = valueOf(4) * v1
```

This problem is solved in `kotlin-big-math` by providing a overloaded operators where one argument is `Int`, `Double` or `Long`.
```kotlin
    // Code example with kotlin-big-math

    val v1 = valueOf(2)
    val v2 = v1 * 3
    val v3 = 4.0 * v1
```


## Using kotlin-big-math in your projects

To use the kotlin library you can either download the newest version of the .jar file from the
[published releases on Github](https://github.com/eobermuhlner/kotlin-big-math/releases/)
or use the following dependency to
[Maven Central](https://search.maven.org/#search%7Cga%7C1%7Ckotlin-big-math)
in your build script (please verify the version number to be the newest release):

### Use kotlin-big-math in Maven Build

```xml
<dependency>
    <groupId>ch.obermuhlner</groupId>
    <artifactId>kotlin-big-math</artifactId>
    <version>2.3.0</version>
</dependency>
```

### Use kotlin-big-math in Gradle Build

```gradle
repositories {
  mavenCentral()
}

dependencies {
  compile 'ch.obermuhlner:kotlin-big-math:2.3.0'
}
```
