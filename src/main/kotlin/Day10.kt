class Day10 {

    class Register() {
        var x: Int = 0
        lateinit var cycles: List<Int>
    }

    fun part1(input: String): Int {
        val cycles = parseInput(input)

        return  getSumOfCyclesSince(cycles, 20) +
                getSumOfCyclesSince(cycles, 60) +
                getSumOfCyclesSince(cycles, 100) +
                getSumOfCyclesSince(cycles, 140) +
                getSumOfCyclesSince(cycles, 180) +
                getSumOfCyclesSince(cycles, 220)
    }

    fun parseInput(input: String): List<Int> {
        val splitted = input.split("\n")

        val x = 1
        var cycles = listOf<Int>()
        for (line in splitted) {
            if (line == "noop") {
                cycles = cycles.plus(0)
            } else {
                cycles = cycles.plus(0)
                cycles = cycles.plus((Integer.parseInt(line.split(" ")[1])))
            }
        }
        return cycles
    }

    fun getSumOfCyclesSince(cycles: List<Int>, number: Int) : Int {

        val sum = (cycles.take(number-1).sumOf { it } ) + 1
        println("sum is $sum")
        return sum * number
    }


    fun part2(input: String)  {
        val parsed = parseInput(input)
        var  spritePosition = 1
        var res =""

        var x =0
        for (i in parsed.indices) {
            if((x == 40)) {
                res += "\n"
                x = 0

            }
            if (isInWindow(spritePosition, x)) {
                res += "#"
            } else {
                res += " "
            }
            spritePosition += parsed[i]
            x++
        }
        println(res)
    }

    private fun printSpritePosition(spritePosition: Int) {
        println("=== sprite position ===")
        for (j in 0..40) {
            if (isInWindow(spritePosition, j))
                print("#")
            else
                print("")
        }
        print("\n")
        print("\n")
    }

    fun isInWindow(spritePosition: Int, currentDrawing: Int): Boolean {
        return (currentDrawing == spritePosition-1) || (currentDrawing == spritePosition) || (currentDrawing == spritePosition + 1)
    }

}


    fun main(args: Array<String>) {
                val d = Day10()
       println(d.part1(Utils.readInput(10)))
       println(d.part2(Utils.readInput(10)))
    }