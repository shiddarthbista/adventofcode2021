package day01

import java.io.File

fun main() {

    val testInput = File("src/day01/input.txt")
        .readLines()
        .map { it.toInt() }


    val size = testInput.size-1

    var total = 0

    for (number in 0 until size) {
        if (testInput[number] < testInput[number + 1]){
            total += 1
        }
    }
    println(total)

    //optimal solution
    val count = testInput.zipWithNext().count(){(x,y) -> y > x}
    println(count)
}





