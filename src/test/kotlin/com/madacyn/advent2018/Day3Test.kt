package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

internal class Day3Test: ShouldSpec({
    "Test Contructor" {
        val claim = Claim("#1164 @ 339,619: 25x10")
        println(claim)
    }

    val inputFilename = "2018_day3_input"

    "Test Puzzle1 example" {
        Day3(
            "#1 @ 1,3: 4x4\n" +
                    "#2 @ 3,1: 4x4\n" +
                    "#3 @ 5,5: 2x2"
        ).puzzle1(8, 8) shouldBe 4
    }

    "Test Puzzle1" {
        Day3(getInput(inputFilename)).puzzle1() shouldBe 110389
    }

    "Test Puzzle2 example" {
        Day3(
            "#1 @ 1,3: 4x4\n" +
                    "#2 @ 3,1: 4x4\n" +
                    "#3 @ 5,5: 2x2"
        ).puzzle2(8, 8) shouldBe 3
    }

    "Test Puzzle2" {
        Day3(getInput(inputFilename)).puzzle2() shouldBe 552
    }
})