class Day08 {
    enum class Dir {
        up,
        down,
        left,
        right
    }
    fun part1(input: String): Int {
        val parsed = parseInput(input)
        var res = 0
        for (i in parsed.indices) {
            for (j in 0 until parsed[i].size) {
                println("checking $i $j")
                if(isHighest(parsed,i,j, parsed[i][j], Dir.left)) {
                    println("visible for left")
                    res ++
                    continue
                }
                else if(isHighest(parsed,i,j, parsed[i][j], Dir.right)) {
                    println("visible for right")
                    res ++
                    continue
                }

                else if(isHighest(parsed,i,j, parsed[i][j], Dir.up)) {
                    println("visible for up")
                    res ++
                    continue
                }
                else if(isHighest(parsed,i,j, parsed[i][j], Dir.down))  {
                    println("visible for up")
                    res ++
                    continue
                }
            }
        }

        return res
    }


    fun isHighest(matrix: List<List<Int>>, i: Int, j: Int, value: Int, dir: Dir): Boolean {
        var x = 0

        when(dir) {
            Dir.left -> {
                val res = true
                x = j
                while (x < matrix[i].size-1) {
                    x++
                    if(value <= matrix[i][x]) return false
                }
                println("$value ($i $j) is visible")
                return res
            }

            Dir.right -> {
                val res = true
                x = j
                while (x > 0) {
                    x--
                    if(value <= matrix[i][x]) return false
                }
                println("$value ($i $j) is visible")
                return res
            }
            Dir.up -> {
                val res = true
                x = i
                while (x > 0) {
                    x--
                    if(value <= matrix[x][j]) return false
                }
                println("$value ($i $j) is visible")
                return res

            }

            Dir.down ->  {
                val res = true
                x = i
                while (x  <  matrix.size-1) {
                    x++
                    if(value <= matrix[x][j]) return false
                }
                println("$value ($i $j) is visible")
                return res
            }
        }


    }


    fun parseInput(input: String): List<List<Int>> {
        return input.split("\n")
            .map { it.toCharArray().map { c -> Integer.parseInt(c.toString()) } }
    }


    fun part2(input: String): Int {
        val parsed = parseInput(input)
        var list = listOf<Int>()
        for (i in parsed.indices) {
            for (j in 0 until parsed[i].size) {
                println("checking $i $j")
                list = list.plus(
                    countScenicScore(parsed, i, j, parsed[i][j], Dir.left) *
                    countScenicScore(parsed, i, j, parsed[i][j], Dir.right) *
                    countScenicScore(parsed, i, j, parsed[i][j], Dir.up) *
                    countScenicScore(parsed, i, j, parsed[i][j], Dir.down)
                )
            }
        }

        return list.maxOf { it }
    }

    private fun countScenicScore(matrix: List<List<Int>>, i: Int, j: Int, value: Int, dir: Dir): Int {
        var x = 0
        var res = 0
        when(dir) {
            Dir.left -> {
                var res = 0
                x = j
                while (x < matrix[i].size-1) {
                    x++
                    res++

                    if(value <= matrix[i][x]) return res

                }
                println("$value ($i $j) is visible")
                return res
            }

            Dir.right -> {
                x = j
                while (x > 0) {
                    x--
                    res++
                    if(value <= matrix[i][x]) return res

                }
                println("$value ($i $j) is visible")
                return res
            }
            Dir.up -> {
                x = i
                while (x > 0) {
                    x--
                    res++
                    if(value <= matrix[x][j]) return res

                }
                println("$value ($i $j) is visible")
                return res

            }

            Dir.down ->  {
                x = i
                while (x  <  matrix.size-1) {
                    x++
                    res++
                    if(value <= matrix[x][j]) return res

                }
                println("$value ($i $j) is visible")
                return res
            }
        }
    }


}


    fun main(args: Array<String>) {
                val d = Day08()
       println(d.part1(Utils.readInput(8)))
       println(d.part2(Utils.readInput(8)))
    }