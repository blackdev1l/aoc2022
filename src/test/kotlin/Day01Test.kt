import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*


internal class Day01Test {
    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    private val d : Day01 = Day01()
    @Test
    fun part1() {
        assertEquals(24000,  d.part1(readInput(1).toString()))
    }





    @Test
    fun part2() {
        assertEquals(45000,  d.part2(readInput(1).toString()))
    }
}