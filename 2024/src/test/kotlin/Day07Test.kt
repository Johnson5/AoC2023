import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day07Test {
     private val sampleInput = ("190: 10 19\n" +
             "3267: 81 40 27\n" +
             "83: 17 5\n" +
             "156: 15 6\n" +
             "7290: 6 8 6 15\n" +
             "161011: 16 10 13\n" +
             "192: 17 8 14\n" +
             "21037: 9 7 18 13\n" +
             "292: 11 6 16 20").lines()
     private val realInput = readInput("/day07")

     @Test
     fun testPart1() {
         val result = Day07.part1(sampleInput)
         assertEquals(3749, result)
     }

     @Test
     fun testPart2() {
         val result = Day07.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day07.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day07.part2(realInput)
         println("Part 2 result: $result")
     }
 }