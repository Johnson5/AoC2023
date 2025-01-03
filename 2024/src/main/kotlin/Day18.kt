object Day18 {
    fun part1(input: List<String>): Int {
        val fallenBytes = input.subList(0, 1024)
        val obstacles = fallenBytes.map{Pair(Coordinate(it.split(",")[0].toInt(), it.split(",")[1].toInt()), true)}.toMap()

        val width = 71
        val height = 71
        val distances = Grid<Int> (width, height, -1)

        val queue = ArrayDeque<Coordinate>()
        queue.add(Coordinate(0,0))
        distances.set(Coordinate(0,0), 0)

        while(queue.isNotEmpty()) {
            val first = queue.removeFirst()
            for(step in listOf(first.up(), first.down(), first.left(), first.right())) {
                if(distances.isInBounds(step) && distances.at(step) == -1) {
                    if(!obstacles.contains(step)) {
                        distances.set(step, distances.at(first)!! + 1)
                        queue.add(step)
                    }
                }
            }
        }
        return distances.at(Coordinate(width - 1, height - 1))!!
    }

    fun part2(input: List<String>): Int {
        var tryRegA = 0
        return tryRegA - 1
    }
}