import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day08Test {
     private val sampleInput = ("............\n" +
             "........0...\n" +
             ".....0......\n" +
             ".......0....\n" +
             "....0.......\n" +
             "......A.....\n" +
             "............\n" +
             "............\n" +
             "........A...\n" +
             ".........A..\n" +
             "............\n" +
             "............").lines()
     private val realInput = readInput("/day08")

     @Test
     fun testPart1() {
         val result = Day08.part1(sampleInput)
         assertEquals(14, result)
     }

     @Test
     fun testPart2() {
         val result = Day08.part2(sampleInput)
         assertEquals(34, result)
     }

     @Test
     fun runPart1() {
         val result = Day08.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day08.part2(realInput)
         println("Part 2 result: $result")
     }
 }