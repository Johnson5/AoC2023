import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day12Test {
     private val sampleInput = ("RRRRIICCFF\n" +
             "RRRRIICCCF\n" +
             "VVRRRCCFFF\n" +
             "VVRCCCJFFF\n" +
             "VVVVCJJCFE\n" +
             "VVIVCCJJEE\n" +
             "VVIIICJJEE\n" +
             "MIIIIIJJEE\n" +
             "MIIISIJEEE\n" +
             "MMMISSJEEE").lines()
     private val realInput = readInput("/day12")

     @Test
     fun testPart1() {
         val result = Day12.part1(sampleInput)
         assertEquals(1930, result)
     }

     @Test
     fun testPart2() {
         val result = Day12.part2(sampleInput)
         assertEquals(81, result)
     }

     @Test
     fun runPart1() {
         val result = Day12.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day12.part2(realInput)
         println("Part 2 result: $result")
     }
 }