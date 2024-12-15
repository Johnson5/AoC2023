object Day09 {
    fun part1(input: List<String>): Long {
        var diskMap = input[0].toCharArray()
        var disk = mutableListOf<Long>()

        var pointsToFile = true
        var id = 0L
        for (char in diskMap) {
            var size = char.code - '0'.code
            while (size > 0) {
                disk.add(if (pointsToFile) id else -1)
                size--
            }
            if (pointsToFile) { id ++ }
            pointsToFile = !pointsToFile
        }

        var emptyPointer = disk.indexOfFirst {it == -1L}
        var lastPointer = disk.indexOfLast {it != -1L}
        while (emptyPointer != lastPointer) {
            disk[emptyPointer] = disk[lastPointer]
            disk[lastPointer] = -1
            while(emptyPointer != lastPointer && disk[emptyPointer] != -1L) {
                emptyPointer++
            }
            while(lastPointer != emptyPointer && disk[lastPointer] == -1L) {
                lastPointer--
            }
        }

        println(disk)

        var checksum = disk.filter {it != -1L}.foldIndexed(0L) { index, acc, number -> acc + (number * index)}
        return checksum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }
}