

class Day03 {
    fun part1(input: String): Int {

        return  input.split("\n")
            .map { it.chunked(it.length/2) }
            .sumOf { getPriority((it[0].toSet() intersect it[1].toSet()).single()) }
    }

    fun part2(input: String): Int {
        return input.split("\n")
            .chunked(3)
            .sumOf {
                getPriority((it[0].toSet() intersect  it[1].toSet() intersect it[2].toSet()).single())
            }
    }

    fun getPriority(ch: Char): Int {
        return if (ch.isLowerCase()) Character.getNumericValue(ch) - 9
        else Character.getNumericValue(ch) + 17
    }
}