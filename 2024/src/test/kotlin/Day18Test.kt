import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day18Test {
     private val sampleInput = ("5,4\n" +
             "4,2\n" +
             "4,5\n" +
             "3,0\n" +
             "2,1\n" +
             "6,3\n" +
             "2,4\n" +
             "1,5\n" +
             "0,6\n" +
             "3,3\n" +
             "2,6\n" +
             "5,1\n" +
             "1,2\n" +
             "5,5\n" +
             "2,5\n" +
             "6,5\n" +
             "1,4\n" +
             "0,4\n" +
             "6,4\n" +
             "1,1\n" +
             "6,1\n" +
             "1,0\n" +
             "0,5\n" +
             "1,6\n" +
             "2,0").lines()
     private val realInput = readInput("/day18")

     @Test
     fun testPart1() {
         val result = Day18.part1(sampleInput)
         assertEquals(22, result)
     }

     @Test
     fun testPart2() {
         val result = Day18.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day18.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day18.part2(realInput)
         println("Part 2 result: $result")
     }
 }