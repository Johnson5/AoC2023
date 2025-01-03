object Day13 {
    fun part1(input: List<String>): Int {
        var score = 0
        for(block in input){
            val lines = block.lines()
            val (x1, x2) = Pair(lines[0].substringAfter('+').substringBefore(',').toInt(), lines[0].substringAfterLast('+').toInt())
            val (y1, y2) = Pair(lines[1].substringAfter('+').substringBefore(',').toInt(), lines[1].substringAfterLast('+').toInt())
            val (z1, z2) = Pair(lines[2].substringAfter('=').substringBefore(',').toInt(), lines[2].substringAfterLast('=').toInt())

            val b = (z2 * x1 - z1 * x2) / (y2 * x1 - y1 * x2)
            val a = (z1 - b * y1) / x1

            if(Pair(x1 * a + y1 * b, x2 * a + y2 * b) != Pair(z1,z2)) {
                continue;
            }
            else score += a * 3 + b
        }
        return score
    }

    fun part2(input: List<String>): Long {
        var score = 0L
        for(block in input){
            val lines = block.lines()
            val (x1, x2) = Pair(lines[0].substringAfter('+').substringBefore(',').toInt(), lines[0].substringAfterLast('+').toInt())
            val (y1, y2) = Pair(lines[1].substringAfter('+').substringBefore(',').toInt(), lines[1].substringAfterLast('+').toInt())
            val (z1, z2) = Pair(lines[2].substringAfter('=').substringBefore(',').toLong() + 10000000000000, lines[2].substringAfterLast('=').toLong() + 10000000000000)

            val b = (z2 * x1 - z1 * x2) / (y2 * x1 - y1 * x2)
            val a = (z1 - b * y1) / x1

            if(Pair(x1 * a + y1 * b, x2 * a + y2 * b) != Pair(z1,z2)) {
                continue;
            }
            else score += a * 3 + b
        }
        return score
    }
}