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