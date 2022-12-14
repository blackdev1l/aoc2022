import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class Day05 {
    class Operator {
        var crates = HashMap<Int, List<String>>()
        var orders = ArrayList<Order>()


        fun solve1() {
            for (order in this.orders) {
                val moving = crates[order.from - 1]!!.take(order.amount)
                crates[order.from - 1] = crates[order.from - 1]!!.drop(order.amount)
                crates[order.to -1] =  move1( crates[order.to -1]!!, moving)
            }
        }

        fun move1(list1: List<String>, list2: List<String>): List<String> {
            return (list2.reversed().plus(list1))
        }

        fun move2(list1: List<String>, list2: List<String>): List<String> {
            return (list2.plus(list1))
        }

        fun solve2() {
            for (order in this.orders) {
                val moving = crates[order.from - 1]!!.take(order.amount)
                crates[order.from - 1] = crates[order.from - 1]!!.drop(order.amount)
                crates[order.to -1] =  move2( crates[order.to -1]!!, moving)
            }

        }

    }

    class Order {
        var amount = 0
        var from = 0
        var to = 0
    }

    fun part1(input: String): String {
        val operator = parseInput(input)
        operator.solve1()
        return operator.crates
            .filter{ it.value.isNotEmpty() }
            .map { it.value.first() }
            .reduce {acc, next -> acc + next}
    }

    fun part2(input: String): String {
        val operator = parseInput(input)
        operator.solve2()
        return operator.crates
            .filter{ it.value.isNotEmpty() }
            .map { it.value.first() }
            .reduce {acc, next -> acc + next}
    }


    fun parseInput(input: String): Operator {
        var res = Operator()
        res.crates[0] = ArrayList<String>()
        res.crates[1] = ArrayList<String>()
        res.crates[2] = ArrayList<String>()
        res.orders = ArrayList()

        val crates = input
            .split("\n\n")[0]
            .split("\n")

        for (i in 0..crates.size-1) {
            val c = crates[i].toCharArray()
            var j = 1
            var currentStack = 0
            while(j <= c.size) {

                if(res.crates[currentStack] == null) {
                    res.crates[currentStack] = listOf()
                }
                if(c[j].isLetter()) {
                    res.crates[currentStack] = res.crates[currentStack]!!.plus(c[j].toString())
                }

                j+=4
                currentStack++
            }

        }



        for (or in input.split("\n\n")[1].split("\n")) {
            val splittedOr = or.split(" ")

            val order = Order()
            order.amount = splittedOr[1].toInt()
            order.from = splittedOr[3].toInt()
            order.to = splittedOr[5].toInt()

            res.orders.add(order)
        }


        return res
    }
}

fun main() {
    val d = Day05()
    println(d.part1(Utils.readInput(5)))
    println(d.part2(Utils.readInput(5)))
}