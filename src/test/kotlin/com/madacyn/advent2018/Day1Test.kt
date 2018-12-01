package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

internal class Day1Test : ShouldSpec({

    val inputFilename = "2018_day1_input"

    "Verify puzzle1 examples" {
        Day1("+1, +1, +1", ",").puzzle1() shouldBe 3
        Day1("+1, +1, -2", ",").puzzle1() shouldBe 0
        Day1("-1, -2, -3", ",").puzzle1() shouldBe -6
    }

    "Verify puzzle2 examples" {
        Day1("+1, -1", ",").puzzle2() shouldBe 0
        Day1("+3, +3, +4, -2, -4", ",").puzzle2() shouldBe 10
        Day1("-6, +3, +8, +5, -6", ",").puzzle2() shouldBe 5
        Day1("+7, +7, -2, -7, -4", ",").puzzle2() shouldBe 14
    }

    "Verify my unique puzzle input" {
        Day1(getInput(inputFilename)).puzzle1() shouldBe 592
        Day1(getInput(inputFilename)).puzzle2() shouldBe 241
    }
})