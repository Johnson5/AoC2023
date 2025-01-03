import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day14Test {
     private val sampleInput = ("p=0,4 v=3,-3\n" +
             "p=6,3 v=-1,-3\n" +
             "p=10,3 v=-1,2\n" +
             "p=2,0 v=2,-1\n" +
             "p=0,0 v=1,3\n" +
             "p=3,0 v=-2,-2\n" +
             "p=7,6 v=-1,-3\n" +
             "p=3,0 v=-1,-2\n" +
             "p=9,3 v=2,3\n" +
             "p=7,3 v=-1,2\n" +
             "p=2,4 v=2,-3\n" +
             "p=9,5 v=-3,-3").lines()
     private val realInput = readInput("/day14")

     @Test
     fun testPart1() {
         val result = Day14.part1(sampleInput)
         assertEquals(12, result)
     }

     @Test
     fun testPart2() {
         val result = Day14.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day14.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day14.part2(realInput)
         println("Part 2 result: $result")
     }
 }