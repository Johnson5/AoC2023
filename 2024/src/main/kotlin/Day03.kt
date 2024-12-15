object Day03 {
    fun part1(input: List<String>): Int {
        val regex = Regex("mul\\(\\d+,\\d+\\)")
        var total = 0
        for(line in input) {
            val found = regex.findAll(line)
            found.forEach {
                val numsStr = Regex("\\d+").findAll(it.value).map{it.value}.toList()
                val mult = numsStr[0].toInt() * numsStr[1].toInt()
                total += mult
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        val asNums = input.map { it.split(" ").map{ it.toInt() } }
        return input.size
    }
}