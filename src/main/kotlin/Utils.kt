class Utils {
    companion object {
        fun readInput(day: Int): String {
            return {}.javaClass.getResource(String.format("day_%02d.txt", day))?.readText()!!
        }
    }
}