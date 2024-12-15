object Day02 {
    fun part1(input: List<String>): Int {
        var safeCount = 0

        for(line in input) {
            val nums = line.split(" ").map{ it.toInt() }
            var increases = nums[0] < nums[1]
            var prev :Int? = null

            var safe = true
            for(num in nums){
                if(prev == null) {
                    prev = num
                    continue
                }

                var diff = num - prev
                prev = num
                if(increases) {
                    if(diff <= 0 || diff > 3){
                        safe = false
                        break
                    }
                } else {
                    if(diff >= 0 || diff < -3){
                        safe = false
                        break
                    }
                }
            }
            if(safe){ safeCount++ }
        }
        return safeCount
    }

    fun part2(input: List<String>): Int {
        val asNums = input.map { it.split(" ").map{ it.toInt() } }
        return input.size
    }
}