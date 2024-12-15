object Day04 {
    fun part1(input: List<String>): Int {
        fun searchWord(x: Int, y: Int, grid: List<List<Char>>): Int {
            var count = 0
            if (grid[x][y] == 'X') {
                //search right
                if(grid.size > x+3 && grid[x+1][y] == 'M' && grid[x+2][y] == 'A' && grid[x+3][y] == 'S') count++
                //search left
                if (x-3 >= 0 && grid[x-1][y] == 'M' && grid[x-2][y] == 'A' && grid[x-3][y] == 'S') count++
                //search down
                if(grid[x].size > y+3 && grid[x][y+1] == 'M' && grid[x][y+2] == 'A' && grid[x][y+3] == 'S') count++
                //search up
                if(y-3 >= 0 && grid[x][y-1] == 'M' && grid[x][y-2] == 'A' && grid[x][y-3] == 'S') count++
                //search tr
                if(grid.size > x+3 && y-3 >= 0 && grid[x+1][y-1] == 'M' && grid[x+2][y-2] == 'A' && grid[x+3][y-3] == 'S') count++
                //search tl
                if(x-3 >= 0 && y - 3 >= 0 && grid[x-1][y-1] == 'M' && grid[x-2][y-2] == 'A' && grid[x-3][y-3] == 'S') count++
                //search br
                if(grid.size > x+3 && grid[x].size > y+3 && grid[x+1][y+1] == 'M' && grid[x+2][y+2] == 'A' && grid[x+3][y+3] == 'S') count++
                //search bl
                if(grid[x].size > y+3 && x-3 >= 0 && grid[x-1][y+1] == 'M' && grid[x-2][y+2] == 'A' && grid[x-3][y+3] == 'S') count++
            }
            return count;
        }

        var total = 0;
        var grid: List<List<Char>> = input.map { it.toList() }
        grid.forEachIndexed() { x, row ->
            row.forEachIndexed { y, col ->
               total += searchWord(x, y, grid)
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}