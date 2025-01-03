import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day17Test {
     private val sampleInput = ("Register A: 2024\n" +
             "Register B: 0\n" +
             "Register C: 0\n" +
             "\n" +
             "Program: 0,3,5,4,3,0").lines()

     private val realInput = readInput("/day17")

     @Test
     fun testPart1() {
         val result = Day17.part1(sampleInput)
         assertEquals("4,6,3,5,6,3,5,2,1,0", result)
     }

     @Test
     fun testPart2() {
         val result = Day17.part2(sampleInput)
         assertEquals(117440, result)
     }

     @Test
     fun runPart1() {
         val result = Day17.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day17.part2(realInput)
         println("Part 2 result: $result")
     }
 }