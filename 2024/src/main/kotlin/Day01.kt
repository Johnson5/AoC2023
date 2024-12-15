import kotlin.math.abs

object Day01 {
    fun part1(input: List<String>): Int {
        var listA = mutableListOf<Int>()
        var listB = mutableListOf<Int>()
        input.forEach { l ->
            var nums = l.split("   ")
            listA.add(nums[0].toInt())
            listB.add(nums[1].toInt())
        }
        listA.sort()
        listB.sort()

        var diffSum = 0
        for(i in 0 ..< listA.size) {
            var diff = abs(listA[i] - listB[i])
            diffSum += diff
        }
        return diffSum
    }

    fun part2(input: List<String>): Int {
        var map = mutableMapOf<Int, Int>()
        input.forEach { l ->
            var nums = l.split("   ")
            var valNum = nums[1].toInt()
            var value = map[valNum]
            if(value == null) {
                map[valNum] = 1
            } else {
                map[valNum] = value + 1
            }
        }

        var result = 0
        input.forEach { l ->
            var nums = l.split("   ")
            var keyNum = nums[0].toInt()
            var value = map[keyNum]
            if(value != null) {
                result += keyNum * value
            }
        }

        return result
    }
}