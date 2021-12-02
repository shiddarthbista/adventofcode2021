package day02

import java.io.File

fun main() {

    val input = File("src/day02/input.txt")
        .readLines()

    val commands = input.map {
        val (directionStr, lengthStr) = it.split(" ")
        val direction = when(directionStr){
            "up" -> Direction.UP
            "down" -> Direction.DOWN
            "forward" -> Direction.FORWARD
            else -> error("Unknown direction $directionStr")
        }
        Command(direction,lengthStr.toInt())
    }


    fun destination (commands: List<Command>): Int{
        var depth = 0
        var position = 0
        for (command in commands){
            when (command.direction){
                Direction.FORWARD -> position+= command.length
                Direction.DOWN -> depth += command.length
                Direction.UP -> depth -= command.length
            }
        }
        return depth * position
    }

    println(destination(commands))
}

enum class Direction {UP, DOWN, FORWARD}

private data class Command (var direction : Direction,var length: Int)

