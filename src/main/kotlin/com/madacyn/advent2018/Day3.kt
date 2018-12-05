package com.madacyn.advent2018

class Day3(input: String, delimiter: String = "\n") {

    private val parsedInput = input.split(delimiter.toRegex()).map { Claim(it) }

    fun puzzle1(width: Int = 1000, height: Int = 1000): Int {
        val sheet = Array(width) {CharArray(height) {'.'} } // Create and init 2D array of '.'
        markClaims(parsedInput, sheet) // Mark all claims on the sheet
        //printSheet(array)

        return sheet.sumBy { row -> row.count { it == 'X' } } // Count number of 'X' in sheet
    }

    fun puzzle2(width: Int = 1000, height: Int = 1000): Int {
        val sheet = Array(width) {CharArray(height) {'.'} } // Create and init 2D array of '.'
        markClaims(parsedInput, sheet) // Mark all claims on the sheet

        // Find Claim ID that has no overlaps
        return parsedInput.find {
            val xRange = getXRange(it)
            val yRange = getYRange(it)

            sheet.slice(xRange).all { row -> // Get X range
                row.slice(yRange).all { node -> node == '#' } // Get Y range and check if there are no overlaps
            }
        }?.claimId ?: 0
    }

    private fun markClaims(claims: List<Claim>, sheet: Array<CharArray>): Array<CharArray> {
        claims.forEach {
            val xRange = getXRange(it)
            val yRange = getYRange(it)

            // Mark Each Claim
            xRange.forEach { x ->
                yRange.forEach { y ->
                    sheet[x][y] = when (sheet[x][y]) {
                        '.' -> '#' // If not claimed yet, mark as claimed (#)
                        else -> 'X' // This spot as been claimed, mark as overlap (X)
                    }
                }
            }
        }

        return sheet
    }

    private fun getXRange(claim: Claim) = IntRange(claim.fromLeft, claim.fromLeft + (claim.width - 1))
    private fun getYRange(claim: Claim) = IntRange(claim.fromTop, claim.fromTop + (claim.height - 1))

    fun printSheet(sheet: Array<CharArray>) {
        sheet.forEach { row ->
            row.forEach { node ->
                print(node)
            }
            println()
        }
    }


}

data class Claim(val instruction: String) {
    val claimId: Int
    val fromLeft: Int
    val fromTop: Int
    val width: Int
    val height: Int

    init {
        val instructions = instruction.split('#', '@', ',', ':', 'x').drop(1).map { it.trim() } // Split by delimiters and drop the leading #
        claimId = instructions[0].toInt()
        fromLeft = instructions[1].toInt()
        fromTop = instructions[2].toInt()
        width = instructions[3].toInt()
        height = instructions[4].toInt()
    }
}