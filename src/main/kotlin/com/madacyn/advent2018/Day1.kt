package com.madacyn.advent2018

import com.ginsberg.cirkle.circular

class Day1(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex()).map { it.trim().toInt() }

    fun puzzle1(): Int {
        return parsedInput.sum()
    }

    fun puzzle2(): Int {
        val foundFrequencies = mutableMapOf(0 to 1) // Starts at 0, so that counts :)
        val circularInput = parsedInput.circular() // Circular list since we want to iterate until we find our predicate

        var currentFrequency = 0 // Used to track the current frequency
        var index = 0 // Used as an index for our circular list

        while (foundFrequencies[currentFrequency] != 2) { // Loop until we have a frequency we've reached twice
            currentFrequency += circularInput[index] // Add increment
            foundFrequencies[currentFrequency] = foundFrequencies.getOrDefault(currentFrequency, 0) +
                    1 // Insert or add 1
            index++ // Increment our index
        }

        return currentFrequency // Return the frequency we've reached twice
    }
}