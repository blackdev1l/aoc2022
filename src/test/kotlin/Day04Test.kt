import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day04Test {
    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    val d = Day04()
    @Test
    fun part1() {
       assertEquals(2,  d.part1(readInput(4)!!))
    }

    @Test
    fun part2() {
        assertEquals(4,  d.part2(readInput(4)!!))
    }

    @Test
    fun writeSet() {
       val input =  listOf("2-4", "6-8")
        d.writeSets(input)
    }
}