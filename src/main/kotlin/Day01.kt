import java.util.stream.Collectors

class Day01 {

    private fun ints(input: String) = input.split("\n\n")
        .map { it.split("\n").sumOf { s -> Integer.parseInt(s) } }

    fun part1(input: String): Int {
        return  ints(input).max()
    }

    fun part2(input: String): Int {
        return ints(input).sortedDescending().take(3).sum()
    }

}


fun main() {
    val d = Day01()
    println(d.part1(Utils.readInput(1)))
    println(d.part2(Utils.readInput(1)))
}