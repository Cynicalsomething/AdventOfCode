package com.madacyn.advent2018

import kotlin.math.abs

class Day6(input: String) {

    private val points = input.split("\n").flatMap {
        it.split(",").zipWithNext { a, b -> Point(a.trim().toInt(), b.trim().toInt()) }
    }
    private val xRange = points.minBy { it.x }!!.x..points.maxBy { it.x }!!.x // range of x coordinates
    private val yRange = points.minBy { it.y }!!.y..points.maxBy { it.y }!!.y // range of y coordinates

    fun puzzle1(): Int {
        val infinitePoints: MutableSet<Point> = mutableSetOf() // Will hold Points determined to be infinite
        return xRange.asSequence().flatMap { x ->
            yRange.asSequence().map { y ->
                val closest = points.map { it to it.distanceTo(x, y) }.sortedBy { it.second }.take(2) // Get the 2 closest points to x,y
                if (isInfiniteArea(x, y)) { // Is this infinite?
                    infinitePoints.add(closest[0].first) // Add this point to our infinite set
                }
                closest[0].first.takeUnless { closest[1].second == closest[0].second } // throw away this one if it is a tie
            }
        }
            .filterNot { it in infinitePoints } // Filter non-infinite points
            .groupingBy { it }.eachCount() // group these by point and get the count of closest points
            .maxBy { it.value }!!.value // get the highest count of closest points
    }

    fun puzzle2(range: Int): Int = xRange.asSequence().flatMap { x ->
        yRange.asSequence().map { y ->
            points.map { it.distanceTo(x, y) }.sum() // sum up the distance to all points
        }
    }.filter { it < range }.count() // filter out any over the distance range and count up the remaining points

    private fun isInfiniteArea(x: Int, y: Int) =
        x == xRange.first || x == xRange.last || y == yRange.first || y == yRange.last
}

class Point(val x: Int, val y: Int) {
    fun distanceTo(xPt: Int, yPt: Int) = abs(x - xPt) + abs(y - yPt)
}