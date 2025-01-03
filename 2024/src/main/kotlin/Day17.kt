object Day17 {
    fun part1(input: List<String>): String {
        var regA = input[0].substringAfter(": ").toInt()
        var regB = input[1].substringAfter(": ").toInt()
        var regC = input[2].substringAfter(": ").toInt()
        var stack = input[4].substringAfter(": ").split(",").map{it.toInt()}
        var pointer = 0
        var output = mutableListOf<Int>()

        while(pointer < stack.size) {
            val opcode = stack[pointer]
            pointer++
            val operand = stack[pointer]
            pointer++

            when(opcode) {
                0 -> regA = adv(operand, regA, regB, regC)
                1 -> regB = regB xor operand
                2 -> regB = bst(operand, regA, regB, regC)
                3 -> if(regA != 0) pointer = operand
                4 -> regB = regB xor regC
                5 -> output.add(bst(operand, regA, regB, regC))
                6 -> regB = adv(operand, regA, regB, regC)
                7 -> regC = adv(operand, regA, regB, regC)
            }
        }

        return output.joinToString(",")
    }

    fun adv(operand: Int, regA: Int, regB: Int, regC: Int): Int {
        var operandValue = if(operand < 4) operand else { when(operand) { 4 -> regA 5 -> regB 6 -> regC else -> 0} }
        return regA / Math.pow(2.0, operandValue.toDouble()).toInt()
    }

    fun bst(operand: Int, regA: Int, regB: Int, regC: Int): Int {
        var operandValue = if(operand < 4) operand else { when(operand) { 4 -> regA 5 -> regB 6 -> regC else -> 0} }
        return operandValue % 8
    }


    fun part2(input: List<String>): Int {
        val program = input[4].substringAfter(": ")
        var tryRegA = 0
        var output = mutableListOf<Int>()
        while(program != output.joinToString(",")) {
            output = mutableListOf<Int>()
            var regA = tryRegA
            var regB = input[1].substringAfter(": ").toInt()
            var regC = input[2].substringAfter(": ").toInt()
            var stack = program.split(",").map{it.toInt()}
            var pointer = 0


            while(pointer < stack.size) {
                val opcode = stack[pointer]
                pointer++
                val operand = stack[pointer]
                pointer++

                when(opcode) {
                    0 -> regA = adv(operand, regA, regB, regC)
                    1 -> regB = regB xor operand
                    2 -> regB = bst(operand, regA, regB, regC)
                    3 -> if(regA != 0) pointer = operand
                    4 -> regB = regB xor regC
                    5 -> output.add(bst(operand, regA, regB, regC))
                    6 -> regB = adv(operand, regA, regB, regC)
                    7 -> regC = adv(operand, regA, regB, regC)
                }
            }
            //if(tryRegA % 10000 == 0) println(tryRegA)
            tryRegA++
        }
        return tryRegA - 1
    }
}