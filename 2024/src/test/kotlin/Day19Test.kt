import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day19Test {
     private val sampleInput = ("r, wr, b, g, bwu, rb, gb, br\n" +
             "\n" +
             "brwrr\n" +
             "bggr\n" +
             "gbbr\n" +
             "rrbgbr\n" +
             "ubwu\n" +
             "bwurrg\n" +
             "brgr\n" +
             "bbrgwb").split("\n\n")
     private val realInput = readInputEmptyLine("/day19")

     @Test
     fun testPart1() {
         val result = Day19.part1(sampleInput)
         assertEquals(6, result)
     }

     @Test
     fun testPart2() {
         val result = Day19.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day19.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day19.part2(realInput)
         println("Part 2 result: $result")
     }
 }