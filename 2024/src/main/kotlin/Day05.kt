object Day05 {
    fun part1(input: List<String>): Int {
        var map = mutableMapOf<Int, List<Int>>()
        for(line in input) {
            if (line == "") break;
            var (key, value) = line.split("|").map(String::toInt)
            if(map[key] == null) {
                map.put(key, listOf(value))
            } else {
                map[key] = map[key]!!.plus(value)
            }
        }

        var total = 0
        for(line in input) {
            if(line.contains("|") || line == "") continue;
            var correct = true;
            var nums = line.split(",").map(String::toInt)
            var numsSeen :List<Int> = mutableListOf()
            for(num in nums) {
                numsSeen = numsSeen.plus(num)
                if(map.containsKey(num) && map[num]!!.any{n -> numsSeen.contains(n)}) {
                    correct = false;
                    break;
                }
            }
            if(correct) total += numsSeen[numsSeen.size / 2];
        }
        return total
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}