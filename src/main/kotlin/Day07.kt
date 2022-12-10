class Day07 {



    data class Directory(
        val name: String,
        var children: List<Directory>,
        val parent: Directory?,
        var size: Int,
        var files: List<File> )
    data class File(val name: String?, val size: Int, val Directory: Directory )

    class FileSystem {
          lateinit var current: Directory
          lateinit var system: Directory
    }

    fun part1(input: String): Int {
        val filesystem = parseInput(input)

        return findAtMost(filesystem.system, 0)

    }

    private fun findAtMost(dir: Directory, i: Int): Int {
        var res = i
        for (child in dir.children) {
            println("dir ${child.name} is size ${child.size}")
            if(child.children.isNotEmpty()) {
                res += findAtMost(child, res)
            }
            if(child.size < 100000)
                res += child.size

        }

        return res
    }


    fun parseInput(input: String): FileSystem {
        val filesystem = FileSystem()
        filesystem.system = Directory("/", listOf(), null, 0, listOf())
        for (line in input.split("\n")) {
            val command = line.split(" ")
            if(command[0] == "$") {
                if(command[1] == "cd") {
                    if(command[2] == "/") {
                        filesystem.current = Directory("/", listOf(), null, 0, listOf())
                        filesystem.system = filesystem.current
                        continue
                    }
                   if(command[2] != "..") {
                       filesystem.current = filesystem.current.children?.first { it.name == command[2] }!!
                       continue
                   } else {
                       filesystem.current = filesystem.current.parent!!
                       continue
                   }
                }
            }

            if(command[0] == "dir") {
                filesystem.current.children = filesystem.current.children.plus(Directory(command[1], listOf(), filesystem.current, 0, listOf()))
                continue
            }

            if(command[0].contains("[0-9]".toRegex())) {
                println("found file ${command[1]} with size ${Integer.parseInt(command[0])}")

                filesystem.current.files = filesystem.current.files.plus(File(command[1], Integer.parseInt(command[0]), filesystem.current))
                filesystem.current.size += Integer.parseInt(command[0])

//                println("folder size is now ${filesystem.current.size}")
//                println("folder \"${filesystem.current.name}\" files are ${filesystem.current.files.size}")
                continue
            }
        }

        return filesystem
    }

    fun part2(input: String): Int {
        return 0
    }



}


    fun main(args: Array<String>) {
                val d = Day07()
       println(d.part1(Utils.readInput(7)))
//       println(d.part2(Utils.readInput(6)))
    }