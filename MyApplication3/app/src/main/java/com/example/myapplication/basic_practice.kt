package com.example.myapplication

import java.util.*

fun main() {
    val read = Scanner(System.`in`)
    println("hello, please enter what n'th you'd like");
    var num = read.nextInt()
    println(fib(num))
    println(fib_rec(num))

    val lambdaCompare : (Int, Int) -> Boolean = {a: Int, b: Int -> a>b}
    val lambdaCompare_R : (Int, Int, (Int, Int) -> Boolean) -> Boolean =
        {a: Int, b: Int, fn: (Int, Int) -> Boolean -> !fn(a,b)}


    println(high_ord_comp(1, 2, lambdaCompare))

}
fun high_ord_comp(a: Int, b: Int, fn: (Int, Int) -> Boolean): Boolean {
    return fn(a,b)
}
fun fib(a: Int): Int {
    if (a <= 1)
        return a
    var n_1= 0; var n_2 = 1; var n = 0
    for (i in 0..a-1) {
        n = n_1 + n_2
        n_2 = n_1
        n_1 = n
    }
    return n
}

fun fib_rec(a: Int): Int {
    if (a <= 1)
        return a
    return (fib_rec(a-1) + fib_rec(a-2))
}

fun