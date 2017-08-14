package com.ryl.learn.kotlin

import kotlin.coroutines.experimental.buildSequence

/**
 * Created on 17/5/19 18:19.
 */
open class FirstDemo {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum2(a: Int, b: Int) = a + b

    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a + $b = ${a + b}")
    }
    
    
}

data class Customer (val id: Int, val name : String)

fun String.spaceToCamel() : String {
    var result : String = ""
    for(word in this.split(" ")) {
        print(word)
    }
    return result
}



fun main(args: Array<String>) {
    println("Hello World")
    val a: Int = 1
    val b = 2
    val c: Int
    c = 3
    println("$a $b $c")

    var x = 4
    x += 1
    println(x)
    
    val s1 = "a is $a"
    val s2 = "${s1.replace("is","was")}, but now is $a"
    println("s1=$s1 s2=$s2")
    
    var items = listOf("apple","banana","kiwi")
    for(item in items) {
        println(item)
    }
    for(index in items.indices) {
        println("item at $index is ${items[index]}")
    }
    
    println(Customer(23, "zhangsan").toString())
    
    println("my name is zhangsan".spaceToCamel())

//    val seq = buildSequence {
//        println("Yielding 1")
//        yield(1)
//        println("Yielding 2")
//        yield(2)
//        println("Yielding a range")
//        yieldAll(3 .. 5)
//    }
//    
//    for(i in seq) {
//        println("Generated $i")
//    }
    
}