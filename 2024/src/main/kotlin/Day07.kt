object Day07 {
    enum class Op {
        Plus, Times
    }

    fun part1(input: List<String>): Long {
        var total: Long = 0;
        for (line in input) {
            val (testValueStr, numsStr) = line.split(":")
            val testValue = testValueStr.trim().toLong()
            val nums = numsStr.trim().split(" ").map { it.toLong() }
            val operators = arrayOf(Op.Plus, Op.Times)

            var equations: MutableList<MutableList<Op>> = mutableListOf()
            val operatorCount = nums.size - 1;
            val amountOfPerms = Math.pow(2.toDouble(), operatorCount.toDouble()).toInt();

            for (i in 0 until amountOfPerms) {
                var equation: MutableList<Op> = mutableListOf()
                var temp = i
                for (j in 0 until operatorCount) {
                    var op = operators[temp % operators.size]
                    equation.add(op)
                    temp /= operators.size
                }
                equations.add(equation)
            }


            for (equation in equations) {
                var thisValue: Long = nums[0]
                equation.forEachIndexed({ index, op ->
                    when (op) {
                        Op.Plus -> thisValue += nums[index + 1]
                        Op.Times -> thisValue *= nums[index + 1]
                    }
                })
                if (thisValue == testValue) {
                    total += testValue;
                    break;
                }
            }

        }
        return total;
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}