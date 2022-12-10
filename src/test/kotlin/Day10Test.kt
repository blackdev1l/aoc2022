import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day10Test {
    val d = Day10()
    val input = readInput(10)!!

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    @Test
    fun part1() {
        assertEquals(13140,d.part1(input))
    }

    @Test
    fun part2() {
        d.part2(input)
    }

    @Test
    fun getSumOfCyclesSince() {
        val cycles = d.parseInput(input)
        assertEquals(420,d.getSumOfCyclesSince(cycles, 20))
        assertEquals(1140,d.getSumOfCyclesSince(cycles, 60))
        assertEquals(1800,d.getSumOfCyclesSince(cycles, 100))
        assertEquals(2940,d.getSumOfCyclesSince(cycles, 140))
        assertEquals(3960,d.getSumOfCyclesSince(cycles, 220))
    }
}