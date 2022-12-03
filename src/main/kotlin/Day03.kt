import java.lang.Exception

class Day03 {
    fun part1(input: String): Int {

        return input.split("\n")
            .map {
                getPriority(findCommonChar(splitRuckSack(it)))
            }.sum()


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

    fun findCommonChar(lists: List<List<Char>>): Char {
        val l1 = lists[0]
        val l2 = lists[1]
        return l1.intersect(l2.toSet()).first()
    }

    fun splitRuckSack(ruckSack: String): List<List<Char>> {
        val l = ruckSack.length
        val arr = ruckSack.toCharArray()
        val firstList = ArrayList<Char>()
        val secondList = ArrayList<Char>()
        for (i in 0 until l) {
            if (i < l / 2) {
                firstList += arr[i]
            } else {
                secondList += arr[i]
            }
        }
        return listOf(firstList, secondList)
    }

}