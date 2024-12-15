import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day10Test {
     private val sampleInput = ("89010123\n" +
             "78121874\n" +
             "87430965\n" +
             "96549874\n" +
             "45678903\n" +
             "32019012\n" +
             "01329801\n" +
             "10456732").lines()
     private val realInput = readInput("/day10")

     @Test
     fun testPart1() {
         val result = Day10.part1(sampleInput)
         assertEquals(36, result)
     }

     @Test
     fun testPart2() {
         val result = Day10.part2(sampleInput)
         assertEquals(81, result)
     }

     @Test
     fun runPart1() {
         val result = Day10.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day10.part2(realInput)
         println("Part 2 result: $result")
     }
 }