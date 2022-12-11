class Day11 {
    data class Monkey(var items: List<Int>,
                      val operation: Pair<String, String>,
                      val test: Int,
                      val ifTrue: Int,
                      val ifFalse: Int,
                      var inspection: Int = 0)

    fun part1(input: String): Int {
        val monkeys = parseInput(input)

        for (i in 1..20) {
            round(monkeys, true)
        }


        val result = monkeys.map { it.inspection}.sorted().reversed().take(2).reduce { acc, i ->  acc * i }
        return result
    }

    fun part2(input: String): Int {
        val monkeys = parseInput(input)

        for (i in 1..10000) {
            round(monkeys, false)
        }


        val result = monkeys.map { it.inspection}.sorted().reversed().take(2).reduce { acc, i ->  acc * i }
        return result
    }


    private fun round(monkeys: List<Monkey>, divideByThree: Boolean) {

        var i = 0
//        println("round $i")
        for (monkey in monkeys) {
//            println("Monkey: $i")
            for (item in monkey.items) {
                monkey.items = monkey.items.drop(1)
//                println("\tMonkey inspects an item with a worry level of $item")
                monkey.inspection++
                var newItem = operation(monkey.operation, item)
//                println("\t\tWorry level is (${monkey.operation.first}) by ${monkey.operation.second} to $newItem.")
                if(divideByThree) newItem /= 3

//                println("\t\tMonkey gets bored with item. Worry level is divided by 3 to $newItem.")

                if (newItem % monkey.test == 0) {
//                    println("\t\tCurrent worry level is divisible by ${monkey.test}.")
//                    println("\t\tItem with worry level $newItem is thrown to monkey ${monkey.ifTrue}.")
                    monkeys[monkey.ifTrue].items = monkeys[monkey.ifTrue].items.plus(newItem)
                } else {
//                    println("\t\tCurrent worry level is not divisible by ${monkey.test}.")
//                    println("\t\tItem with worry level $newItem is thrown to monkey ${monkey.ifFalse}.")
                    monkeys[monkey.ifFalse].items = monkeys[monkey.ifFalse].items.plus(newItem)
                }
            }
            i++

        }
    }

    fun parseInput(input: String) : List<Monkey> {
        return input.split("\n").chunked(7).map { toMonkey(it) }
    }

    fun operation(pair: Pair<String, String>, item: Int): Int {
        var x = item
        if(pair.second != "old" ) x = Integer.parseInt(pair.second)


        when (pair.first) {
            "+" -> return item + x
            "*" -> return item * x
        }

        return 0

    }


    fun toMonkey(input: List<String>): Monkey {
        val items = input[1].replace("Starting items: ","").split(",").map { Integer.parseInt(it.trim()) }
        val operationParsed =input[2].replace("Operation: new = old ","").trim().split(" ")
        val operation = Pair(operationParsed[0],operationParsed[1])
        val test = Integer.parseInt(input[3].replace("Test: divisible by ","").trim())
        val ifTrue = Integer.parseInt(input[4].replace("If true: throw to monkey ", "").trim())
        val ifFalse = Integer.parseInt(input[5].replace("If false: throw to monkey ", "").trim())


        return Monkey(items, operation, test, ifTrue, ifFalse)


    }

}


    fun main(args: Array<String>) {
                val d = Day11()
       println(d.part1(Utils.readInput(11)))
       println(d.part2(Utils.readInput(11)))
    }