import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day16Test {
     private val sampleInput = ("###############\n" +
             "#.......#....E#\n" +
             "#.#.###.#.###.#\n" +
             "#.....#.#...#.#\n" +
             "#.###.#####.#.#\n" +
             "#.#.#.......#.#\n" +
             "#.#.#####.###.#\n" +
             "#...........#.#\n" +
             "###.#.#####.#.#\n" +
             "#...#.....#.#.#\n" +
             "#.#.#.###.#.#.#\n" +
             "#.....#...#.#.#\n" +
             "#.###.#.#.#.#.#\n" +
             "#S..#.....#...#\n" +
             "###############").lines()

     private val realInput = readInput("/day16")

     @Test
     fun testPart1() {
         val result = Day16.part1(sampleInput)
         assertEquals(2028, result)
     }

     @Test
     fun testPart2() {
         val result = Day15.part2(sampleInput)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day16.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day16.part2(realInput)
         println("Part 2 result: $result")
     }
 }