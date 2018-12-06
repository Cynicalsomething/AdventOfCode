package com.madacyn.advent2018

class Day4(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex()).sorted()
    private val minuteRegex = """\d{2}:(\d{2})]""".toRegex()
    private val guardNumRegex = """#(\d{1,6}) """.toRegex()

    fun puzzle1(): Int {
        val guardMap = createGuardSleepMap()
        val guardChosen = guardMap.maxBy { it.value.size }!!.key // Choose a guard that slept the most minutes
        val minuteChosen = guardMap[guardChosen]!!.groupBy { it }.maxBy { it.value.count() }!!.key // Find minute most frequently asleep

        return guardChosen * minuteChosen // Multiply the GuardID by minute most frequently asleep
    }

    fun puzzle2(): Int {
        val guardMap = createGuardSleepMap()
        val guardToMinute = guardMap.flatMap { it.value.map { v-> it.key to v } } // Create a List of Pairs (Guard ID to Minute)

        return guardToMinute.groupBy { it }.maxBy { it.value.size }!!.key.run { first * second } // Group by the Pair of GuardID to Minute, and find the most frequent Pair
    }

    /**
     * Creates a map of all the minutes a guard was asleep (GuardId -> List of all minutes)
     */
    private fun createGuardSleepMap(): Map<Int, List<Int>> {
        val guardMap: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        var currentGuard = 0
        var sleepStart = 0
        var sleepEnd: Int

        parsedInput.forEach {
            when {
                it.contains(guardNumRegex) -> currentGuard = guardNumRegex.groupAsInt(it)
                it.contains("asleep") -> sleepStart = minuteRegex.groupAsInt(it)
                else -> {
                    sleepEnd = minuteRegex.groupAsInt(it)
                    guardMap[currentGuard] = guardMap.getOrDefault(currentGuard, mutableListOf()).apply { addAll(
                        sleepStart until sleepEnd
                    ) }
                }
            }
        }

        return guardMap
    }

    private fun Regex.groupAsInt(s: String) = this.find(s)!!.groups[1]!!.value.toInt()
}
