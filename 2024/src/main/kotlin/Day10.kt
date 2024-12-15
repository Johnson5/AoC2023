object Day10 {
    fun part1(input: List<String>): Int {
        val grid = Grid<Int> (input) {it.toInt()}
        var trailheads = grid.coordinatesWhere { it == 0 }

        val scores = trailheads.map {dfs1(it, grid)}
        println(scores)

        return scores.sum()
    }

    fun dfs1(start: Coordinate, grid: Grid<Int>): Int {
        var stack = ArrayDeque<Coordinate>()
        stack.add(start)
        var validNines = mutableSetOf<Coordinate>()

        while (stack.isNotEmpty()) {
            val coordinate = stack.removeFirst()
            val value = grid.at(coordinate)
            if(value == 9) validNines.add(coordinate)
            else {
                val validNeighbours = searchNeighbours(coordinate, grid, value!!)
                stack.addAll(0, validNeighbours)
            }
        }
        return validNines.size
    }

    fun searchNeighbours(coordinate: Coordinate, grid: Grid<Int>, value: Int): MutableList<Coordinate> {
        var list = mutableListOf<Coordinate>()
        val (x,y) = coordinate
        if(grid.at(x+1, y) == value + 1) list.add(Coordinate(x+1, y))
        if(grid.at(x-1, y) == value + 1) list.add(Coordinate(x-1, y))
        if(grid.at(x, y+1) == value + 1) list.add(Coordinate(x, y + 1))
        if(grid.at(x, y - 1) == value + 1) list.add(Coordinate(x, y - 1))
        return list
    }

    fun dfs2(start: Coordinate, grid: Grid<Int>): Int {
        var stack = ArrayDeque<Coordinate>()
        stack.add(start)
        var validTrails = 0

        while (stack.isNotEmpty()) {
            val coordinate = stack.removeFirst()
            val value = grid.at(coordinate)
            if(value == 9) validTrails ++
            else {
                val validNeighbours = searchNeighbours(coordinate, grid, value!!)
                stack.addAll(0, validNeighbours)
            }
        }
        return validTrails
    }


    fun part2(input: List<String>): Int {
        val grid = Grid<Int> (input) {it.toInt()}
        var trailheads = grid.coordinatesWhere { it == 0 }

        val scores = trailheads.map {dfs2(it, grid)}
        println(scores)
        return scores.sum()
    }
}