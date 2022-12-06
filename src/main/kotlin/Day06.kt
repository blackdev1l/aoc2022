class Day06 {

    fun solve(input: String, count: Int): Int {
        var tempInput = input
        var res = 0
        while (tempInput.isNotEmpty()) {
           val t = tempInput.take(count)
            tempInput = tempInput.drop(1)
            res++
            if(t.toSet().size == count) {
                return res+(count-1)
            }
        }

        return -1;

    }




}


    fun main(args: Array<String>) {
                val d = Day06()
       println(d.solve(Utils.readInput(6), 4))
       println(d.solve(Utils.readInput(6), 14))
    }