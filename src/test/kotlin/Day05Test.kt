import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class Day05Test {

    fun readInput(day: Int): String? {
        return {}.javaClass.getResource(String.format("day_%02d_ex.txt", day))?.readText()
    }
    val d = Day05()

    @Test
    fun parseInput() {

        d.parseInput(readInput(5)!!)
    }

    @Test
    fun part1() {
        assertEquals("CMZ", d.part1(readInput(5)!!))
    }
}