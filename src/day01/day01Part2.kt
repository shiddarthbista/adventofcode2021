package day01

import java.io.File

fun main() {

    val testInput = File("src/day01/input.txt")
        .readLines()
        .map { it.toInt() }

    var size = testInput.size - 3
    var total = 0
    var firstSum = 0
    var secondSum = 0

    for (number in 0 until size) {
        firstSum = testInput[number] + testInput[number + 1] + testInput[number + 2]
        secondSum = testInput[number + 1] + testInput[number + 2] + testInput[number + 3]
        if (secondSum > firstSum) {
            total += 1
        }
    }

    println(total)


}