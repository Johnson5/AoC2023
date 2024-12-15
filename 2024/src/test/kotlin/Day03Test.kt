import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day03Test {
     private val sampleInput = ("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))").lines()

     private val realInput = readInput("/day03")

     @Test
     fun testPart1() {
         val result = Day03.part1(sampleInput)
         assertEquals(161, result)
     }

     @Test
     fun testPart2() {
         val result = Day03.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day03.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day03.part2(realInput)
         println("Part 2 result: $result")
     }
 }