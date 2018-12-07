package com.madacyn.advent2018

class Day5(private val input: String) {

    fun puzzle1(): Int {
        return removeReactions(input).length // Remove reactions and return length
    }

    fun puzzle2(): Int {
        val uniqueChars = input.groupBy { it.toLowerCase() }.keys // Group by unique chars
        val charToPolymerMap = mutableMapOf<Char, Int>()
        uniqueChars.forEach {
            // Remove the given char, and then react, placing the resulting length in the map
            charToPolymerMap[it] = removeReactions(input.replace("""[$it${it.toUpperCase()}]""".toRegex(), "")).length
        }
        return charToPolymerMap.values.min() ?: 0 // Return the smallest length
    }

    private fun removeReactions(polymer: String): String =
        polymer.fold(mutableListOf<Char>()) { reacted, char ->
            when {
                isSameLetterDifferentCase(reacted.lastOrNull(), char) -> reacted.dropLast(1).toMutableList()
                else -> {
                    reacted.add(char)
                    reacted
                }
            }
        }.joinToString("")



    private fun isSameLetterDifferentCase(a: Char?, b: Char?) = (a != null && b != null)
            && (a.toUpperCase() == b.toUpperCase()) && (a != b)

}