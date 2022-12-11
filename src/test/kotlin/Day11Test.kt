import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day11Test {

    val d = Day11()
    val input = readInput(11)!!

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    @Test
    fun part1() {
        assertEquals(10605,d.part1(input))
    }

    @Test
    fun parseInput() {
        d.parseInput(input)
    }

    @Test
    fun part2() {
    }
}