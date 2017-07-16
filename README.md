
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

```kotlin
import ch.obermuhlner.math.big.BigFloat
import ch.obermuhlner.math.big.kotlin.*

fun simpleExample() {
	val context = context(100)
	val v1 = (context.valueOf(1) + 1) / 3

	println(v1)
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
