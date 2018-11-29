package com.madacyn.advent2017

import com.madacyn.asDigit
import com.madacyn.getInput

class Day1(private val input: String) {

    fun puzzle1(): Int {
        val inputTemp = input + input[0] // Append first char to end to be "circular"
        return inputTemp.zipWithNext()
            .filter { it.first == it.second }
            .map { it.first.asDigit() }.sum()
    }

    fun puzzle2(): Int {
        val firstHalf = input.substring(0, input.length / 2)
        val secondHalf = input.substring(input.length / 2)

        return firstHalf.zip(secondHalf)
            .filter { it.first == it.second }
            .map { it.first.asDigit() + it.second.asDigit() }.sum()
    }
}

fun main() {
    val day = Day1(getInput("2017_day1_input"))
    println(day.puzzle1())
    println(day.puzzle2())
}