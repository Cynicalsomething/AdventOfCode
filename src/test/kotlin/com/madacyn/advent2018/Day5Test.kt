package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

internal class Day5Test: ShouldSpec({

    val inputFileName = "2018_day5_input"

    "Puzzle 1 Example" {
        Day5("dabAcCaCBAcCcaDA").puzzle1() shouldBe "dabCBAcaDA".length
    }

    "Puzzle 1" {
        Day5(getInput(inputFileName)).puzzle1() shouldBe 9686
    }

    "Puzzle 2 Example" {
        Day5("dabAcCaCBAcCcaDA").puzzle2() shouldBe 4
    }

    "Puzzle 2" {
        Day5(getInput(inputFileName)).puzzle2() shouldBe 5524
    }
})