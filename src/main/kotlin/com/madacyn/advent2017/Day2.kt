package com.madacyn.advent2017

import com.madacyn.getInput

class Day2(input: String) {

    private val parsedInput = input.lines().map { it.split("\\s+".toRegex()).map { it2 -> it2.toInt() } }

    fun puzzle1(): Int {
        return parsedInput.map { it.sorted() }
            .sumBy { it.last() - it.first() }
    }

    fun puzzle2(): Int {
        return parsedInput.map { getEvenlyDivisiblePair(it) }
            .sumBy { it.first / it.second }
    }

    private fun getEvenlyDivisiblePair(line: List<Int>): Pair<Int, Int> {
        return line
            .flatMap { line.map { it2 -> Pair(it, it2) } }
            .filter { it.first != it.second }
            .first { it.first % it.second == 0 }
    }

}

fun main() {
    val day = Day2(getInput("2017_day2_input"))
    println(day.puzzle1())
    println(day.puzzle2())
}