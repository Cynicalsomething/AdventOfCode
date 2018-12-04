package com.madacyn.advent2018

import com.madacyn.getInput
import io.kotlintest.shouldBe
import io.kotlintest.specs.ShouldSpec

internal class Day2Test : ShouldSpec({

    val inputFilename = "2018_day2_input"

    "Verify puzzle1 examples" {
        Day2("").hasExactlyNLetters("abcdef", 2) shouldBe false
        Day2("").hasExactlyNLetters("abcdef", 3) shouldBe false

        Day2("").hasExactlyNLetters("bababc", 2) shouldBe true
        Day2("").hasExactlyNLetters("bababc", 3) shouldBe true

        Day2("").hasExactlyNLetters("abbcde", 2) shouldBe true
        Day2("").hasExactlyNLetters("abbcde", 3) shouldBe false

        Day2("").hasExactlyNLetters("abcccd", 2) shouldBe false
        Day2("").hasExactlyNLetters("abcccd", 3) shouldBe true

        Day2("").hasExactlyNLetters("aabcdd", 2) shouldBe true
        Day2("").hasExactlyNLetters("aabcdd", 3) shouldBe false

        Day2("").hasExactlyNLetters("abcdee", 2) shouldBe true
        Day2("").hasExactlyNLetters("abcdee", 3) shouldBe false

        Day2("").hasExactlyNLetters("ababab", 2) shouldBe false
        Day2("").hasExactlyNLetters("ababab", 3) shouldBe true
    }

    "Verify checksum" {
        Day2("abcdef,bababc,abbcde,abcccd,aabcdd,abcdee,ababab", ",").puzzle1() shouldBe 12
    }

    "Verify puzzle1" {
        Day2(getInput(inputFilename)).puzzle1() shouldBe 5681
    }

    "Verify off by one" {
        "TEST".isOffByOne("TEST") shouldBe false
        "TEST".isOffByOne("TESR") shouldBe true
        "TEST".isOffByOne("REST") shouldBe true
        "TEST".isOffByOne("TSET") shouldBe false
    }

    "Verify puzzle2 example" {
        Day2("abcde,fghij,klmno,pqrst,fguij,axcye,wvxyz", ",").puzzle2() shouldBe "fgij"
    }

    "Verify puzzle2" {
        Day2(getInput(inputFilename)).puzzle2() shouldBe "uqyoeizfvmbistpkgnocjtwld"
    }
})