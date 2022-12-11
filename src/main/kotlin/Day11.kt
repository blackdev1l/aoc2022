import java.math.BigInteger

class Day11 {
    data class Monkey(var items: List<BigInteger>,
                      val operation: Pair<String, String>,
                      val test: Int,
                      val ifTrue: Int,
                      val ifFalse: Int,
                      var inspection: BigInteger = BigInteger.ZERO)

    fun part1(input: String): BigInteger {
        val monkeys = parseInput(input)

        for (i in 1..20) {
            round(monkeys, true)
        }

        return monkeys.map { it.inspection }.sorted().reversed().take(2).reduce { acc, i -> acc * i }
    }

    fun part2(input: String): BigInteger {
        val monkeys = parseInput(input)

        for (i in 1..10000) {
            round(monkeys, false)
        }

        return monkeys.map { it.inspection }.sorted().reversed().take(2).reduce { acc, i -> acc * i }
    }


    private fun round(monkeys: List<Monkey>, divideByThree: Boolean) {

        val mcm = monkeys.map{it.test}.reduce{acc, next -> acc * next}
        for (monkey in monkeys) {
            for (item in monkey.items) {
                monkey.items = monkey.items.drop(1)
                monkey.inspection++
                var newItem = operation(monkey.operation, item)
                if (newItem < BigInteger.ZERO) {
                    println("newItems is $newItem from $item ${monkey.operation.first}  ${monkey.operation.second}")
                }
                if(divideByThree) newItem /= BigInteger.valueOf(3L)

                if (newItem % monkey.test.toBigInteger() == BigInteger.ZERO) {
                    newItem = newItem.mod(mcm.toBigInteger())
                    monkeys[monkey.ifTrue].items += newItem
                } else {
                    newItem = newItem.mod(mcm.toBigInteger())
                    monkeys[monkey.ifFalse].items += newItem
                }
            }
        }
    }

    fun parseInput(input: String) : List<Monkey> {
        return input.split("\n").chunked(7).map { toMonkey(it) }
    }

    fun operation(pair: Pair<String, String>, item: BigInteger): BigInteger {
        var x = item
        if(pair.second != "old" ) x = Integer.parseInt(pair.second).toBigInteger()


        when (pair.first) {
            "+" -> return item + x
            "*" -> return item * x
        }

        return BigInteger.ZERO

    }


    fun toMonkey(input: List<String>): Monkey {
        val items = input[1].replace("Starting items: ","").split(",").map { Integer.parseInt(it.trim()).toBigInteger() }
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