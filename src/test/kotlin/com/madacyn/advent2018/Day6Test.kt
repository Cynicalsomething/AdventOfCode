package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

class Day6Test: ShouldSpec({

    val puzzleExampleInput = "1, 1\n" +
            "1, 6\n" +
            "8, 3\n" +
            "3, 4\n" +
            "5, 5\n" +
            "8, 9"
    val inputFilename = "2018_day6_input"

    "Puzzle 1 Examples" {
        Day6(puzzleExampleInput).puzzle1() shouldBe 17
    }

    "Puzzle 1" {
        Day6(getInput(inputFilename)).puzzle1() shouldBe 3660
    }

    "Puzzle 2 Example" {
        Day6(puzzleExampleInput).puzzle2(32) shouldBe 16
    }

    "Puzzle 2" {
        Day6(getInput(inputFilename)).puzzle2(10000) shouldBe 35928
    }
})