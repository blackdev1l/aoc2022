import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class Day06Test {

    val d = Day06()
    @Test
    fun part1() {
        var example = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        assertEquals(7, d.solve(example, 4))
        example = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        assertEquals(5, d.solve(example, 4))
    }

    @Test
    fun part2() {
        val example = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        assertEquals(19, d.solve(example, 14))
    }
}