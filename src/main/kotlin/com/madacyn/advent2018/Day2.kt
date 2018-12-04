package com.madacyn.advent2018

class Day2(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex()).map { it.trim() }

    fun puzzle1(): Int {
        val twice = parsedInput.count { hasExactlyNLetters(it, 2) } // Exactly 2 letters
        val thrice = parsedInput.count { hasExactlyNLetters(it, 3) } // Exactly 3 letters
        return twice * thrice // Generate Checksum
    }

    fun puzzle2(): String {
        val ids = mutableSetOf<String>()

        parsedInput.forEach {
            ids.addAll(parsedInput.filter { it2 -> it.isOffByOne(it2) }) // Get all Strings that differ by 1 char
        }

        return ids.first().commonPrefixWith(ids.last()) + ids.first().commonSuffixWith(ids.last()) // Substring before difference + Substring after difference
    }

    fun hasExactlyNLetters(input: String, n: Int): Boolean {
        val uniqueChars = input.groupBy { it } // Group all chars in string
        return input.toCharArray().distinct().find { uniqueChars[it]?.count() == n } != null // Find a char that has exactly n letters
    }
}

fun String.isOffByOne(other: String) = this.filterIndexed { index, c -> other[index] != c }.count() == 1 // Check if other differs by 1 char