import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day05Test {
     private val sampleInput = ("47|53\n" +
             "97|13\n" +
             "97|61\n" +
             "97|47\n" +
             "75|29\n" +
             "61|13\n" +
             "75|53\n" +
             "29|13\n" +
             "97|29\n" +
             "53|29\n" +
             "61|53\n" +
             "97|53\n" +
             "61|29\n" +
             "47|13\n" +
             "75|47\n" +
             "97|75\n" +
             "47|61\n" +
             "75|61\n" +
             "47|29\n" +
             "75|13\n" +
             "53|13\n" +
             "\n" +
             "75,47,61,53,29\n" +
             "97,61,53,29,13\n" +
             "75,29,13\n" +
             "75,97,47,61,53\n" +
             "61,13,29\n" +
             "97,13,75,29,47").lines()
     private val realInput = readInput("/day05")

     @Test
     fun testPart1() {
         val result = Day05.part1(sampleInput)
         assertEquals(143, result)
     }

     @Test
     fun testPart2() {
         val result = Day05.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day05.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day05.part2(realInput)
         println("Part 2 result: $result")
     }
 }