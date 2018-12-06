package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

internal class Day4Test: ShouldSpec({

    val exampleInput = "[1518-11-01 00:00] Guard #10 begins shift\n" +
            "[1518-11-01 00:05] falls asleep\n" +
            "[1518-11-01 00:25] wakes up\n" +
            "[1518-11-01 00:30] falls asleep\n" +
            "[1518-11-01 00:55] wakes up\n" +
            "[1518-11-01 23:58] Guard #99 begins shift\n" +
            "[1518-11-02 00:40] falls asleep\n" +
            "[1518-11-02 00:50] wakes up\n" +
            "[1518-11-03 00:05] Guard #10 begins shift\n" +
            "[1518-11-03 00:24] falls asleep\n" +
            "[1518-11-03 00:29] wakes up\n" +
            "[1518-11-04 00:02] Guard #99 begins shift\n" +
            "[1518-11-04 00:36] falls asleep\n" +
            "[1518-11-04 00:46] wakes up\n" +
            "[1518-11-05 00:03] Guard #99 begins shift\n" +
            "[1518-11-05 00:45] falls asleep\n" +
            "[1518-11-05 00:55] wakes up"

    val inputFilename = "2018_day4_input"

    "Puzzle 1 Example" {
        Day4(exampleInput).puzzle1() shouldBe 240
    }

    "Puzzle 1" {
        Day4(getInput(inputFilename)).puzzle1() shouldBe 19874
    }

    "Puzzle 2 Example" {
        Day4(exampleInput).puzzle2() shouldBe 4455
    }

    "Puzzle 2" {
        Day4(getInput(inputFilename)).puzzle2() shouldBe 22687
    }

})