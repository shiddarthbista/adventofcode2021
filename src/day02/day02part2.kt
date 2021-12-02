package day02

import java.io.File

fun main() {

    val input = File("src/day02/testInput.txt")
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
        var aim = 0
        for (command in commands){
            when (command.direction){
                Direction.FORWARD -> {
                    position += command.length
                    depth += aim * command.length
                }
                Direction.DOWN -> aim += command.length
                Direction.UP -> aim -= command.length
            }
        }
        return depth * position
    }

    println(destination(commands))
}

