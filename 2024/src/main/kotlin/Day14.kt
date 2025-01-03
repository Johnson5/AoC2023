object Day14 {
    fun part1(input: List<String>): Int {
        var scores = mutableListOf<Int>(0,0,0,0)
        var counter = 0
        for (line in input) {
            val (px, py) = line.substringAfter('=').substringBefore(' ').split(",").map { it.toInt() }
            val (vx, vy) = line.substringAfterLast('=').split(",").map { it.toInt() }
            val boardHeight = 103
            val boardWidth = 101
            val t = 100

            val x = (px + vx * t).mod(boardWidth)
            val y = (py + vy * t).mod(boardHeight)

            var quadrant = -1
            counter++
            if(x < boardWidth / 2) {
                if (y < boardHeight / 2) {
                    quadrant = 0
                } else if (y > boardHeight / 2) {
                    quadrant = 2
                }
            } else if (x > boardWidth / 2){
                if (y < boardHeight / 2) {
                    quadrant = 1
                } else if (y > boardHeight / 2) {
                    quadrant = 3
                }
            }
            if(quadrant >= 0) scores[quadrant]++
        }
        println(scores)
        return scores.fold(1, Int::times)
    }

    fun part2(input: List<String>): Int {
        var score = 0

        return score
    }
}