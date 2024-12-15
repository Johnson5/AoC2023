object Day08 {
    fun part1(input: List<String>): Int {
        var max = Pair(input[0].length - 1, input.size - 1)
        var positions = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()
        input.forEachIndexed { y, line ->
            line.forEachIndexed { x, c ->
                if (c != '.') {
                    if(positions.containsKey(c)) {
                        positions[c]!!.add(Pair(x, y))
                    } else {
                        positions[c] = (mutableListOf(Pair(x, y)))
                    }
                }
            }
        }

        var antinodes = mutableSetOf<Pair<Int, Int>>()
        for (pair in positions) {
            var checkedPairs = mutableListOf<Pair<Pair<Int,Int>, Pair<Int,Int>>>()
            for (pos1 in pair.value) {
                for (pos2 in pair.value) {
                    if (pos1 != pos2) {
                        val pair = if (pos1.first < pos2.first || (pos1.first == pos2.first && pos1.second < pos2.second)) Pair(pos1, pos2) else Pair(pos2, pos1)
                        if(!checkedPairs.contains(pair)) checkedPairs.add(pair)

                        val dx = pair.second.first - pair.first.first
                        val dy = pair.second.second - pair.first.second
                        val fromFirst = Pair(pair.first.first - dx, pair.first.second - dy)
                        val fromSecond = Pair(pair.second.first + dx, pair.second.second + dy)
                        if(0 <= fromFirst.first && fromFirst.first <= max.first && 0 <= fromFirst.second && fromFirst.second <= max.second) {
                            antinodes.add(fromFirst)
                        }
                        if(0 <= fromSecond.first && fromSecond.first <= max.first && 0 <= fromSecond.second && fromSecond.second <= max.second) {
                            antinodes.add(fromSecond)
                        }
                    }
                }
            }
        }
        return antinodes.size
    }

    fun part2(input: List<String>): Int {
        var max = Pair(input[0].length - 1, input.size - 1)
        var positions = mutableMapOf<Char, MutableList<Pair<Int, Int>>>()
        input.forEachIndexed { y, line ->
            line.forEachIndexed { x, c ->
                if (c != '.') {
                    if(positions.containsKey(c)) {
                        positions[c]!!.add(Pair(x, y))
                    } else {
                        positions[c] = (mutableListOf(Pair(x, y)))
                    }
                }
            }
        }

        var antinodes = mutableSetOf<Pair<Int, Int>>()
        for (pair in positions) {
            var checkedPairs = mutableListOf<Pair<Pair<Int,Int>, Pair<Int,Int>>>()
            for (pos1 in pair.value) {
                for (pos2 in pair.value) {
                    if (pos1 != pos2) {
                        val pair = if (pos1.first < pos2.first || (pos1.first == pos2.first && pos1.second < pos2.second)) Pair(pos1, pos2) else Pair(pos2, pos1)
                        if(!checkedPairs.contains(pair)) checkedPairs.add(pair)

                        val dx = pair.second.first - pair.first.first
                        val dy = pair.second.second - pair.first.second

                        var firstInBounds = true
                        var secondInBounds = true
                        var firstIter = 0
                        while(firstInBounds) {
                            val fromFirst = Pair(pair.first.first - (dx * firstIter), pair.first.second - (dy * firstIter))

                            if (0 <= fromFirst.first && fromFirst.first <= max.first && 0 <= fromFirst.second && fromFirst.second <= max.second) {
                                antinodes.add(fromFirst)
                            } else {
                                firstInBounds = false
                            }
                            firstIter++
                        }

                        var secondIter = 0
                        while(secondInBounds) {
                            val fromSecond = Pair(pair.second.first + (dx * secondIter), pair.second.second + (dy * secondIter))
                            if(0 <= fromSecond.first && fromSecond.first <= max.first && 0 <= fromSecond.second && fromSecond.second <= max.second) {
                                antinodes.add(fromSecond)
                            } else {
                                secondInBounds = false
                            }
                            secondIter++
                        }
                    }
                }
            }
        }
        println(antinodes)
        return antinodes.size
    }
}