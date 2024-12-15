import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day11Test {
     private val sampleInput = ("0").lines()
     private val realInput = readInput("/day11")

     @Test
     fun testPart1() {
         val result = Day11.part1(sampleInput)
         assertEquals(55312, result)
     }

     @Test
     fun testPart2() {
         val result = Day11.part2(sampleInput)
         assertEquals(81, result)
     }

     @Test
     fun runPart1() {
         val result = Day11.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day11.part2(realInput)
         println("Part 2 result: $result")
     }
 }