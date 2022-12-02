import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day02Test {

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }

    private val d : Day02 = Day02()
    @Test
    fun part1() {
        assertEquals(15,  d.part1(readInput(2).toString()))
    }

    @Test
    fun part2() {
        assertEquals(12,  d.part2(readInput(2).toString()))
    }

}