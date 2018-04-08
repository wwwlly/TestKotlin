package com.kemp.testkotlin

import java.io.File

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        // `obj` is automatically cast to `String` in this branch
        return obj.length
    }

    // `obj` is still of type `Any` outside of the type-checked branch
    return null
}

fun testAnyLength() {
    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: "... err, not a string"} ")
    }
    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))
}

fun testLoop() {
    val items = listOf("apple", "banana", "kiwifruit")
    for (item in items) {
        println(item)
    }
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }
}

fun describe(obj: Any): String =
        when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

fun testWhen() {
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))
}

fun testRang() {
    for (x in 1..5) {
        print(x)
    }
    println()
    for (x in 1..10 step 2) {
        print(x)
    }
    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }
}

fun testCollection() {
    val items = setOf("apple", "banana", "kiwifruit")
    when {
        "orange" in items -> println("juicy")
        "apple" in items -> println("apple is fine too")
    }
}

fun testLambda() {
    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
    fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}

fun testNull() {
    val files = File("Test").listFiles()

    println(files?.size)
    println(files?.size ?: "empty")

    val values = mapOf("a" to 1, "b" to 2)
    val email = values["email"] ?: throw IllegalStateException("Email is missing!")
    println(email)
}

fun String.spaceToCamelCase() {
}

fun main(args: Array<String>) {
//    testAnyLength()
//    testLoop()
//    testWhen()
//    testRang()
//    testCollection()
    testLambda()
//    testNull()
//    "AAA".spaceToCamelCase()
}