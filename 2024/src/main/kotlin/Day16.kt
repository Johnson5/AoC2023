import java.util.*
import kotlin.math.absoluteValue

enum class Direction(val value: Int) {
    UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

    fun turnsTo(other: Direction): Int {
        var diff = (other.value - this.value) % 4

        if (diff < -2) diff += 4
        if (diff > 2) diff -= 4

        return (diff).absoluteValue
    }
}

object Day16 {
    fun part1(input: List<String>): Int {
        var grid = Grid<Char>(input) {it}
        var distances = Grid<Int>(input) {Int.MAX_VALUE}
        var previous = Grid<Coordinate>(input) {Coordinate(-1, -1)}
        var visited = Grid<Boolean>(input) {false}
        var start = grid.coordinatesWhere { it == 'S' }.first()
        var end = grid.coordinatesWhere { it == 'E' }.first()
        var direction = Direction.RIGHT

        var pQueue = PriorityQueue<Coordinate>()
        pQueue.add(start)
        while (!pQueue.isEmpty()) {
            var first = pQueue.poll()
            for(step in listOf(first.up(), first.down(), first.left(), first.right())) {
                if(grid.isInBounds(step) && !visited.at(step)!! && grid.at(step) != '#') {
                    val newDirection = if(step == first.up()) Direction.UP else { if (step == first.down()) Direction.DOWN else { if(step == first.right()) Direction.RIGHT else Direction.LEFT }}
                    var tempDistance = distances.at(step)!! + 1 + (direction.turnsTo(newDirection) * 1000)
                    if(tempDistance < distances.at(step)!!) {
                        distances.set(step, tempDistance)
                        previous.set(step, first)
                        pQueue.add(step)
                    }
                }
            }

        }
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}