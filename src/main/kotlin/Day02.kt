class Day02 {

    val pointsMap = hashMapOf<String, Int>("X" to 1, "Y" to 2, "Z" to 3 )
    val winMap = hashMapOf( "X" to "C", "Y" to "A", "Z" to "B")
    val strategyMap = hashMapOf("A" to "X", "B" to "Y", "C" to "Z" )


    fun part1(input: String): Int {

        return  input.split("\n")
           .map {
               val split = it.split(" ")
               pointsMap[split[1]]!! + battle(split[0], split[1])
           }.sum()
    }

    fun part2(input: String): Int {
        return  input.split("\n")
            .map {
                val split = it.split(" ")
                battle2(split[0], split[1])
            }.sum()
    }

    private fun battle2(theirs: String, strategy: String) : Int {
        val winMapReverse = winMap.entries.associateBy({ it.value }) { it.key }
        val handMap = hashMapOf("A" to "X", "B" to "Y", "C" to "Z" )
        if(strategy == "Y")  {  // draw
            return pointsMap[handMap[theirs]]!! + 3
        }
        return if(strategy == "X")  { // lose
            0 + findLosingHand(theirs)
        } else pointsMap[winMapReverse[theirs]!!]!! + 6 // win
    }

    private fun findLosingHand(theirs: String): Int {
        if(theirs == "A") return  pointsMap["Z"]!!
        return if(theirs == "B") pointsMap["X"]!!
        else pointsMap["Y"]!!
    }

    private fun battle(theirs: String, mine: String): Int {


        if(winMap[mine].equals(theirs)) return 6
        return if(strategyMap[theirs].equals(mine) ) 3
        else 0
    }

}