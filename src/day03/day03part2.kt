package day03

import java.io.File

fun main() {

    val inputs = File("src/day03/testInput.txt").readLines()
    val n = inputs[0].length
    val a0 = IntArray(n)
    val a1 = IntArray(n)

    for (input in inputs){
        for (i in input.indices){
            when (input[i]){
                '0'-> a0[i]++
            }
        }
    }


}