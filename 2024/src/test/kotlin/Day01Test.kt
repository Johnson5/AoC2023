import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day01Test {
     private val realInput = readInput("/day01")

     private val sampleInput = ("3   4\n" +
             "4   3\n" +
             "2   5\n" +
             "1   3\n" +
             "3   9\n" +
             "3   3").lines()

     @Test
     fun testPart1() {
         val result = Day01.part1(sampleInput)
         assertEquals(11, result)
     }

     @Test
     fun testPart2() {
         val result = Day01.part2(sampleInput)
         assertEquals(31, result)
     }

     @Test
     fun runPart1() {
         val result = Day01.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day01.part2(realInput)
         println("Part 2 result: $result")
     }
 }