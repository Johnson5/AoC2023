import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day13Test {
     private val sampleInput = ("Button A: X+94, Y+34\n" +
             "Button B: X+22, Y+67\n" +
             "Prize: X=8400, Y=5400\n" +
             "\n" +
             "Button A: X+26, Y+66\n" +
             "Button B: X+67, Y+21\n" +
             "Prize: X=12748, Y=12176\n" +
             "\n" +
             "Button A: X+17, Y+86\n" +
             "Button B: X+84, Y+37\n" +
             "Prize: X=7870, Y=6450\n" +
             "\n" +
             "Button A: X+69, Y+23\n" +
             "Button B: X+27, Y+71\n" +
             "Prize: X=18641, Y=10279").trim().split("\n\n")
     private val realInput = readInputEmptyLine("/day13")

     @Test
     fun testPart1() {
         val result = Day13.part1(sampleInput)
         assertEquals(480, result)
     }

     @Test
     fun testPart2() {
         val result = Day13.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day13.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day13.part2(realInput)
         println("Part 2 result: $result")
     }
 }