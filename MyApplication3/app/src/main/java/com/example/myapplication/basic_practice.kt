package com.example.myapplication

import android.icu.number.IntegerWidth
import java.util.*
import kotlin.collections.HashMap

fun main() {
    /*val read = Scanner(System.`in`)
    println("hello, please enter what n'th you'd like");
    var num = read.nextInt()
    println(fib(num))
    println(fib_rec(num))

    val lambdaCompare : (Int, Int) -> Boolean = {a: Int, b: Int -> a>b}
    /*val lambdaCompare_R : (Int, Int, (Int, Int) -> Boolean) -> Boolean =
        {a: Int, b: Int, fn: (Int, Int) -> Boolean -> !fn(a,b)}
    */

    println(high_ord_comp(1, 2, lambdaCompare))
    */
    println(reachable_num(130000))
    println(reachable_num_r(130000))


    println(long_num(4, "1337", listOf(1, 2, 5, 4, 6, 6, 3, 1, 9)))
    println(long_num(2, "33", listOf(1, 1, 1, 1, 1, 1, 1, 1, 1)))

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

fun reachable_num(a: Int) : Int {

    var n = a % 10
    if (n != 0)
        return a
    else
        return reachable_num(a/10)
}

tailrec fun reachable_num_r(a: Int) : Int {
    var n = a % 10
    if (n != 0)
        return a
    else
        return reachable_num_r(a/10)
}

fun long_num(n: Int, s: String, l: List<Int>) : String {
    //var ll = s.toList()
    //ll.forEach{it.toInt()}

    var x = s.map{it.toInt().minus('0'.toInt())}.toMutableList()
    for (x_1 in x)
        println(x_1)
    var f = (1..9).zip(l).toMap()

    //greedy algorithm is to simply find a contiguous subsequence (window), starting from the
    // most significant digit, in which every replaced value is greater than its original


    //line below says:
    //find first index (most significant digit) where the function value will replace it
    //with something larger than itself
    //keep it if such a mapping exists, otherwise return the end of the string
    var i = x.indexOfFirst{d -> f.get(d)!! > d}
            .takeIf{it >= 0} ?: s.length

    //line below says:
    //find the first index such that the mapped value will be less than the original
    //while also being larger than the start index
    //this is the "stop" index to our window
    var y = x.withIndex().indexOfFirst{(y, d) -> y > i && f.get(d)!! < d}
            .takeIf{it >= 0} ?: s.length

    if (i == y)
        return s

        println(i)
        println(y)
    (i..y-1).forEach{x[it] = f.get(x[it])!!}
    return x.joinToString("")

}
