import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day07Test {
    val d = Day07()

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }

    @Test
    fun part1() {
        assertEquals(95437, d.part1(readInput(7)!!))
    }

    @Test
    fun part2() {
    }
}