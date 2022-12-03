import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day03Test {

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }

    val d = Day03()

    @Test
    fun splitRuckSack() {
        val splitRuckSack = d.splitRuckSack("vJrwpWtwJgWrhcsFMMfFFhFp")

        assertEquals(2, splitRuckSack.size)
        assertEquals("vJrwpWtwJgWr", String(splitRuckSack[0].toCharArray()))
        assertEquals("hcsFMMfFFhFp", String(splitRuckSack[1].toCharArray()))

    }

    @Test
    fun findCommonChar() {
        val splitRuckSack = d.splitRuckSack("vJrwpWtwJgWrhcsFMMfFFhFp")
        assertEquals('p', d.findCommonChar(splitRuckSack))
    }

    @Test
    fun getPriority() {
        assertEquals(1, d.getPriority('a'))
        assertEquals(2, d.getPriority('b'))
        assertEquals(27, d.getPriority('A'))
        assertEquals(28, d.getPriority('B'))
        assertEquals(16, d.getPriority('p'))
    }

    @Test
    fun part1() {
        assertEquals(157, d.part1(readInput(3)!!))
    }
}