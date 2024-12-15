import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day00Test {
     private val sampleInput = ("").lines()
     private val realInput = readInput("/day01")

     @Test
     fun testPart1() {
         val result = Day00.part1(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun testPart2() {
         val result = Day00.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day00.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day00.part2(realInput)
         println("Part 2 result: $result")
     }
 }