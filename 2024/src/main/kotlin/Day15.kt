object Day15 {
    fun part1(input: List<String>): Int {
        val (gridLines, moveLines) = input.partition {it.startsWith('#')}
        var grid = Grid<Char>(gridLines) {it}
        val moves = moveLines.joinToString("")
        var robot = grid.coordinatesWhere { it == '@' }.first()

        var moveCount = 0
        for(move in moves) {
           when (move){
               '<' -> robot = move(robot, robot.left(), grid)
               '>' -> robot = move(robot, robot.right(), grid)
               'v' -> robot = move(robot, robot.down(), grid)
               '^' -> robot = move(robot, robot.up(), grid)
           }
            moveCount++
        }
        return grid.coordinatesWhere { it == 'O' }.map{ it.y * 100 + it.x }.sum()
    }

    fun move(initPos: Coordinate, newPos: Coordinate, grid: Grid<Char>): Coordinate {
        val dx = newPos.x - initPos.x
        val dy = newPos.y - initPos.y
        var checkPos = newPos
        var steps = 0
        while(grid.at(checkPos) == 'O') {
            checkPos = Coordinate(checkPos.x + dx, checkPos.y + dy)
            steps++
        }
        if(grid.at(checkPos) == '.') {
            while(steps != 0) {
                grid.set(checkPos, 'O')
                checkPos = Coordinate(checkPos.x - dx, checkPos.y - dy)
                steps--
            }
            grid.set(checkPos, '@')
            grid.set(initPos, '.')
            return checkPos
        } else {
            return initPos
        }
    }

    fun part2(input: List<String>): Int {
        var score = 0

        return score
    }
}