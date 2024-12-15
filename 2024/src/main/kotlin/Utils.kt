import kotlin.io.path.Path
import kotlin.io.path.readText

fun readInput(name: String) = Path("src/test/resources/$name.txt").readText().trim().lines()

data class Coordinate(val x: Int, val y: Int) {
    // Override the toString() method to return the format (x, y)
    override fun toString(): String {
        return "($x, $y)"
    }

    fun up(): Coordinate {
        return Coordinate(x, y - 1)
    }
    fun down(): Coordinate {
        return Coordinate(x, y + 1)
    }
    fun left(): Coordinate {
        return Coordinate(x - 1, y)
    }
    fun right(): Coordinate {
        return Coordinate(x + 1, y)
    }
}

class Grid<T>(lines: List<String>, private val converter: (Char) -> T) : Iterable<List<T>> {
    val grid: MutableList<MutableList<T>> = lines.map { row -> row.map(converter).toMutableList() }.toMutableList()

    override fun iterator(): Iterator<List<T>> {
        return grid.iterator()
    }

    fun set(coordinate: Coordinate, value: T) {
        if (isInBounds(coordinate)) {
            grid[coordinate.y][coordinate.x] = value
        } else {
            throw IndexOutOfBoundsException("Coordinate is not in bounds of this grid: $coordinate")
        }
    }

    fun at(coordinate: Coordinate) : T? {
        return if(isInBounds(coordinate)) grid[coordinate.y][coordinate.x]
        else null
    }

    fun at(x: Int, y: Int) : T? {
        return if(isInBounds(x, y)) grid[y][x]
        else null
    }

    fun coordinatesWhere(predicate: (T) -> Boolean) : List<Coordinate> {
        return grid.flatMapIndexed { y, row -> row.mapIndexedNotNull { x, i -> if(predicate(i)) Coordinate(x, y) else null }}
    }

    fun isInBounds(coordinate: Coordinate) : Boolean {
        return (coordinate.x in grid[0].indices) && coordinate.y in grid.indices
    }

    fun isInBounds(x: Int, y: Int) : Boolean {
        return (x in grid[0].indices) && y in grid.indices
    }

    // Returns all indices of the grid (i.e., all coordinates of the elements)
    fun indices(): List<Coordinate> {
        return grid.flatMapIndexed { y, row ->
            row.mapIndexed { x, _ -> Coordinate(x, y) }
        }
    }
}