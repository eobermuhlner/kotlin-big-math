
[![Build Status](https://travis-ci.org/eobermuhlner/kotlin-big-math.svg?branch=master)](https://travis-ci.org/eobermuhlner/kotlin-big-math)
[![Maven Central](https://img.shields.io/maven-central/v/ch.obermuhlner/kotlin-big-math.svg)](https://search.maven.org/#search%7Cga%7C1%7Ckotlib-big-math)

# kotlin-big-math
Kotlin library for BigDecimal math functions (pow, sqrt, log, sin, ...) using arbitrary precision.

## Introduction

This library depends on the [big-math](https://github.com/eobermuhlner/big-math) library and provides additional Kotlin features.

## BigFloat Operators

* `+` operator
* `-` operator
* `*` operator
* `/` operator

* `++` operator
* `--` operator

* `pow` infix method
* `root` infix method

### Usage in Kotlin

The usage of `BigFloat` follows the same rules as described in the [big-math](https://github.com/eobermuhlner/big-math/blob/master/README.md#Usage) library.

```kotlin
import ch.obermuhlner.math.big.BigFloat
import ch.obermuhlner.math.big.kotlin.*

fun simpleExample() {
	val context = context(100)
	val v1 = (context.valueOf(1) + 1) / 3

	println(v1)
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
    <version>0.0.1</version>
</dependency>
```

### Use kotlin-big-math in Gradle Build

```gradle
repositories {
  mavenCentral()
}

dependencies {
  compile 'ch.obermuhlner:kotlin-big-math:0.0.1'
}
```
