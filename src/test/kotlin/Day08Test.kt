import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day08Test {
    val d = Day08()

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    @Test
    fun part1() {
        assertEquals(21, d.part1(readInput(8)!!))
    }



    @Test
    fun part2() {
        assertEquals(8, d.part2(readInput(8)!!))
    }
}