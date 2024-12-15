import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day02Test {
     private val sampleInput = ("7 6 4 2 1\n" +
             "1 2 7 8 9\n" +
             "9 7 6 2 1\n" +
             "1 3 2 4 5\n" +
             "8 6 4 4 1\n" +
             "1 3 6 7 9").lines()

     private val realInput = readInput("/day02")

     @Test
     fun testPart1() {
         val result = Day02.part1(sampleInput)
         assertEquals(2, result)
     }

     @Test
     fun testPart2() {
         val result = Day02.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day02.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day02.part2(realInput)
         println("Part 2 result: $result")
     }
 }