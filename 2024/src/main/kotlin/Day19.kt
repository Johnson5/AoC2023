object Day19 {
    fun part1(input: List<String>): Int {
        val patterns = input[0].split(", ").toMutableSet()
        val goals = input[1].lines()

        return goals.map {canMake(it, patterns)}.filter { it }.size
    }

    fun canMake(goal: String, patterns: MutableSet<String>): Boolean {
        if(goal == "" || goal in patterns) {
            return true
        }
        for (pattern in patterns) {
            if(goal.startsWith(pattern) && canMake(goal.removePrefix(pattern), patterns)) {
                patterns.add(goal)
                return true
            }
        }
        return false
    }

    fun part2(input: List<String>): Int {
        var tryRegA = 0
        return tryRegA - 1
    }
}