package day03

import java.io.File

fun main() {

//    val inputs = File("src/day03/testInput.txt").readLines()
    val inputs = File("src/day03/input.txt").readLines()

    val n = inputs[0].length
    val a0 = IntArray(n)
    val a1 = IntArray(n)

    for (input in inputs) {
        for (i in input.indices){
            when(input[i]){
                '0' -> a0[i]++
                '1' -> a1[i]++
            }
        }
    }

    val g = CharArray(n)
    val e = CharArray(n)
    for (i in 0 until n) if (a0[i] > a1[i]){
        g[i] = '0'
        e[i] = '1'
    }else {
        g[i] = '1'
        e[i] = '0'
    }


    val gammaRate = g.concatToString().toInt(2)
    val epsilonRate = e.concatToString().toInt(2)
    val power = gammaRate * epsilonRate


    println(power)
}


