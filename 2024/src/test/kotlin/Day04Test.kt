import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day04Test {
     private val sampleInput = ("MMMSXXMASM\n" +
             "MSAMXMSMSA\n" +
             "AMXSXMAAMM\n" +
             "MSAMASMSMX\n" +
             "XMASAMXAMM\n" +
             "XXAMMXXAMA\n" +
             "SMSMSASXSS\n" +
             "SAXAMASAAA\n" +
             "MAMMMXMMMM\n" +
             "MXMXAXMASX").lines()

     private val realInput = readInput("/day04")

     @Test
     fun testPart1() {
         val result = Day04.part1(sampleInput)
         assertEquals(18, result)
     }

     @Test
     fun testPart2() {
         val result = Day04.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day04.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day04.part2(realInput)
         println("Part 2 result: $result")
     }
 }