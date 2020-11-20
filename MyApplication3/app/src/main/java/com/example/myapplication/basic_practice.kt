package com.example.myapplication

import java.util.*

fun main() {
    val read = Scanner(System.`in`)
    println("hello, please enter what n'th you'd like");
    var num = read.nextInt()
    println(fib(num))
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