package day06

import java.io.File

class Day06(input: String){

    private val fishesPerDay :LongArray = parseInput(input)

    private fun parseInput(input: String): LongArray =
        LongArray(9).apply {
            input.split(",").map {it.toInt()}.forEach{this[it] += 1L}
        }

    private fun LongArray.rotateLeftInPlace(){
        val leftMost = first()
        this.copyInto(this,startIndex = 1)
        this[this.lastIndex] = leftMost
    }

    private fun simulateDays(days:Int): Long{
        repeat(days) {
            fishesPerDay.rotateLeftInPlace()
            fishesPerDay[6] += fishesPerDay[8]
        }
        return  fishesPerDay.sum()
    }

    fun solvePart1(): Long = simulateDays(80)
}

fun main() {
    val input = "3,4,3,1,2"
    Day06(input).solvePart1()
}