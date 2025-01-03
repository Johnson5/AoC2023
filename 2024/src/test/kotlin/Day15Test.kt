import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

 class Day15Test {
     private val sampleInputS = ("########\n" +
             "#..O.O.#\n" +
             "##@.O..#\n" +
             "#...O..#\n" +
             "#.#.O..#\n" +
             "#...O..#\n" +
             "#......#\n" +
             "########\n" +
             "\n" +
             "<^^>>>vv<v>>v<<").lines()

     private val sampleInputL = ("##########\n" +
             "#..O..O.O#\n" +
             "#......O.#\n" +
             "#.OO..O.O#\n" +
             "#..O@..O.#\n" +
             "#O#..O...#\n" +
             "#O..O..O.#\n" +
             "#.OO.O.OO#\n" +
             "#....O...#\n" +
             "##########\n" +
             "\n" +
             "<vv>^<v^>v>^vv^v>v<>v^v<v<^vv<<<^><<><>>v<vvv<>^v^>^<<<><<v<<<v^vv^v>^\n" +
             "vvv<<^>^v^^><<>>><>^<<><^vv^^<>vvv<>><^^v>^>vv<>v<<<<v<^v>^<^^>>>^<v<v\n" +
             "><>vv>v^v^<>><>>>><^^>vv>v<^^^>>v^v^<^^>v^^>v^<^v>v<>>v^v^<v>v^^<^^vv<\n" +
             "<<v<^>>^^^^>>>v^<>vvv^><v<<<>^^^vv^<vvv>^>v<^^^^v<>^>vvvv><>>v^<<^^^^^\n" +
             "^><^><>>><>^^<<^^v>>><^<v>^<vv>>v>>>^v><>^v><<<<v>>v<v<v>vvv>^<><<>^><\n" +
             "^>><>^v<><^vvv<^^<><v<<<<<><^v<<<><<<^^<v<^^^><^>>^<v^><<<^>>^v<v^v<v^\n" +
             ">^>>^v>vv>^<<^v<>><<><<v<<v><>v<^vv<<<>^^v^>^^>>><<^v>>v^v><^^>>^<>vv^\n" +
             "<><^^>^^^<><vvvvv^v<v<<>^v<v>v<<^><<><<><<<^^<<<^<<>><<><^^^>^^<>^>v<>\n" +
             "^^>vv<^v^v<vv>^<><v<^v>^^^>>>^^vvv^>vvv<>>>^<^>>>>>^<<^v>^vvv<>^<><<v>\n" +
             "v^^>>><<^^<>>^v^<v^vv<>v^<<>^<^v^v><^<<<><<^<v><v<>vv>>v><v^<vv<>v^<<^").lines()

     private val realInput = readInput("/day15")

     @Test
     fun testPart1Small() {
         val result = Day15.part1(sampleInputS)
         assertEquals(2028, result)
     }

     @Test
     fun testPart1() {
         val result = Day15.part1(sampleInputL)
         assertEquals(10092, result)
     }

     @Test
     fun testPart2() {
         val result = Day15.part2(sampleInputL)
         assertEquals(0, result)
     }

     @Test
     fun runPart1() {
         val result = Day15.part1(realInput)
         println("Part 1 result: $result")
     }

     @Test
     fun runPart2() {
         val result = Day15.part2(realInput)
         println("Part 2 result: $result")
     }
 }