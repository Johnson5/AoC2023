object Day12 {
    fun part1(input: List<String>): Int {
        var grid = Grid<Char>(input) { it };
        var mapped = Grid<Boolean>(input) { false }
        var areasAndPerimeters = mutableMapOf<Coordinate, Pair<Int, Int>>()

        for (coordinate in grid.indices()) {
            if (mapped.at(coordinate)!!) continue
            markArea(coordinate, grid, mapped, areasAndPerimeters)
        }
        println("$areasAndPerimeters")
        return areasAndPerimeters.map { it.value.first * it.value.second }.sum()
    }

    fun markArea(
        coordinate: Coordinate,
        grid: Grid<Char>,
        mapped: Grid<Boolean>,
        areasAndPerimeters: MutableMap<Coordinate, Pair<Int, Int>>
    ) {
        var queue = ArrayDeque<Coordinate>()
        val char = grid.at(coordinate)
        var area = 1;
        var perimeter = 0;
        mapped.set(coordinate, true)
        queue.add(coordinate)
        while (!queue.isEmpty()) {
            val first = queue.removeFirst()

            //UP
            if (grid.isInBounds(first.up())) {
                if (grid.at(first.up()) == char && !mapped.at(first.up())!!) {
                    queue.add(first.up())
                    mapped.set(first.up(), true)
                    area++
                } else if(grid.at(first.up()) != char) perimeter++
            } else {
                perimeter++
            }

            //DOWN
            if (grid.isInBounds(first.down())) {
                if (grid.at(first.down()) == char && !mapped.at(first.down())!!) {
                    queue.add(first.down())
                    mapped.set(first.down(), true)
                    area++
                } else if(grid.at(first.down()) != char) perimeter++
            } else {
                perimeter++
            }

            //LEFT
            if (grid.isInBounds(first.left())) {
                if (grid.at(first.left()) == char && !mapped.at(first.left())!!) {
                    queue.add(first.left())
                    mapped.set(first.left(), true)
                    area++
                } else if(grid.at(first.left()) != char) perimeter++
            } else {
                perimeter++
            }

            //RIGHT
            if (grid.isInBounds(first.right())) {
                if (grid.at(first.right()) == char && !mapped.at(first.right())!!) {
                    queue.add(first.right())
                    mapped.set(first.right(), true)
                    area++
                } else if(grid.at(first.right()) != char) perimeter++
            } else {
                perimeter++
            }
        }
        areasAndPerimeters.put(coordinate, Pair(area, perimeter))
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}