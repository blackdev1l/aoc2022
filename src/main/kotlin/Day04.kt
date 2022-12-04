class Day04 {

    fun part1(input: String): Int {
        return input
            .split("\n")
            .map { writeSets(it.split(",")) }
            .count { contains(it) }
    }

    fun part2(input: String): Int {
        return input
            .split("\n")
            .map { writeSets(it.split(",")) }
            .count { containsPartially(it) }
    }

    fun writeSets(list: List<String>): List<Set<Int>> {
        return list.map { getSet(it) }
    }

    fun contains(list: List<Set<Int>>) : Boolean {
        val first = list[0]
        val last = list[1]
        return (first.containsAll(last) || last.containsAll(first))
    }

    fun containsPartially(list: List<Set<Int>>) : Boolean {
        val first = list[0]
        val last = list[1]
        return first.intersect(last).isNotEmpty()
    }

    private fun getSet(s: String): Set<Int> {
        val result = setOf<Int>()
        val i = s.split("-")[0].toInt()
        val j = s.split("-")[1].toInt()

        return result.plus((i..j))
    }
}