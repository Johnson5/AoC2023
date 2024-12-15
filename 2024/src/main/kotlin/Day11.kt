object Day11 {
    fun part1(input: List<String>): Int {
        var stones = input.flatMap { s -> s.split(" ").map{ it.toLong() }}.toMutableList()


        var c = 1
        repeat(25) {
            var i = 0
            while(i < stones.size) {
                val stone = stones[i]
                val stoneStr = stone.toString()
                if (stone == 0L) stones[i] = 1L
                else if (stoneStr.length % 2 == 0) {
                    splitStone(stoneStr, i, stones)
                    i++
                }
                else stones[i] = stone * 2024
                i++
            }
            println("$c, ${stones.size}")
            c++
        }
        return stones.size
    }

    fun splitStone(stoneStr: String, i: Int, stones: MutableList<Long>) {
        val numA = stoneStr.substring(0, stoneStr.length / 2)
        val numB = stoneStr.substring(stoneStr.length / 2)
        stones[i] = numA.toLong()
        stones.add(i + 1, numB.toLong())
    }

    fun part2(input: List<String>): Int {
        var stonesMap = input.flatMap { s -> s.split(" ").map{ it.toLong() }}.groupingBy { it }.eachCount()
        println(stonesMap)

        return 3
//        var c = 1
//        repeat(75) {
//            var i = 0
//            while(i < stones.size) {
//                val stone = stones[i]
//                val stoneStr = stone.toString()
//                if (stone == 0L) stones[i] = 1L
//                else if (stoneStr.length % 2 == 0) {
//                    splitStone(stoneStr, i, stones)
//                    i++
//                }
//                else stones[i] = stone * 2024
//                i++
//            }
//            println("$c, ${stones.size}, ${stones}")
//            c++
//        }
//        return stones.size
    }
}