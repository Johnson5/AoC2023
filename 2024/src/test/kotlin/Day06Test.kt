import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day06Test {
     private val sampleInput = ("....#.....\n" +
             ".........#\n" +
             "..........\n" +
             "..#.......\n" +
             ".......#..\n" +
             "..........\n" +
             ".#..^.....\n" +
             "........#.\n" +
             "#.........\n" +
             "......#...").lines()
     private val realInput = readInput("/day06")

     @Test
     fun testPart1() {
         val result = Day06.part1(sampleInput)
         assertEquals(41, result)
     }

     @Test
     fun testPart2() {
         val result = Day06.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day06.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day06.part2(realInput)
         println("Part 2 result: $result")
     }
 }