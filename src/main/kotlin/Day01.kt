import java.util.stream.Collectors

class Day01 {

    fun part1(input: String): Int {
        var list = (getIntList(input.split(System.lineSeparator())))


        list = list.sortedDescending()

        println(list[0])

        return list[0]
    }

    fun part2(input: String): Int {
        var list = (getIntList(input.split(System.lineSeparator())))
        list = list.sortedDescending()

        return list.take(3).sum()
    }

    private fun getIntList(list: List<String>): List<Int> {
        val res = ArrayList<Int>()
        var temp: Int = 0
        for (i in list.indices) {
            if (list[i].isBlank()) {
                res.add(temp)
                temp = 0
                continue
            }

            temp += Integer.parseInt(list[i])
        }

        return res
    }


}