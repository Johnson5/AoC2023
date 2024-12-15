object Day06 {
    enum class Direction {
        Up,
        Right,
        Down,
        Left;

        fun getNext(): Direction {
            val nextOrdinal = (this.ordinal + 1) % entries.size
            return entries[nextOrdinal]
        }
    }
    fun part1(input: List<String>): Int {
        var maxX = input[0].length - 1
        var maxY = input.size - 1
        var grid = Array(maxX + 1) { Array(maxY + 1) { '.' } }
        var position: Pair<Int, Int> = Pair(0, 0)
        input.forEachIndexed { y, row ->
            row.forEachIndexed { x, char ->
                if (char == '#') {
                    grid[x][y] = '#'
                }
                else if (char == '^') {
                    position = Pair(x, y)
                    grid[x][y] = 'X'
                }
            }
        }
        var totalVisited = 1;
        var direction :Direction = Direction.Up;
        while(position.first < maxX && position.second < maxY && position.first > 0 && position.second > 0) {
            val newPosition = move(grid, position, direction);
            if(newPosition == position) { direction = direction.getNext() }
            else {
                if(grid[newPosition.first][newPosition.second] != 'X') {
                    totalVisited++;
                    grid[newPosition.first][newPosition.second] = 'X'
                }
                position = newPosition
            };
        }
        return totalVisited;
    }

    fun move(grid: Array<Array<Char>>, position: Pair<Int, Int>, direction: Direction): Pair<Int, Int> {
        val newPosition = when (direction) {
            Direction.Up -> Pair(position.first, position.second - 1)
            Direction.Down -> Pair(position.first, position.second + 1)
            Direction.Left -> Pair(position.first - 1, position.second)
            Direction.Right -> Pair(position.first + 1, position.second)
        }
        if(grid[newPosition.first][newPosition.second] == '#') {
            return position;
        } else {
            return newPosition;
        }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}