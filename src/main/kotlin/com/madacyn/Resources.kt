package com.madacyn

internal object Resources

fun getInput(filename: String): String = Resources::class.java.classLoader.getResource("input/$filename.txt").readText()