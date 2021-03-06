package chongdashu.conway

import org.scalatest.FunSuite

object TestBoard {
    val STRING_ALIVE : String = "1"
    val STRING_DEAD : String = "0"
}

/**
  * Created by culim on 6/30/16.
  */
class TestBoard extends FunSuite {

    test("A created 10 x 10 board should have the correct dimensions") {
        val WIDTH : Int = 10;
        val HEIGHT : Int = 10;

        val board : Board = new Board(WIDTH, HEIGHT)

        assert(board.width == WIDTH, "Board's width should be 10")
        assert(board.height == HEIGHT, "Board's height should be 10")
        assert(board.cells.length == WIDTH*HEIGHT, "Board #rows should be 10")
        assert(board.cells(0) !== None, "Board rows should be initialized")
    }

    test("A created 5 x 10 board should have the correct dimensions") {
        val WIDTH : Int = 5;
        val HEIGHT : Int = 10;

        val board : Board = new Board(WIDTH, HEIGHT)

        assert(board.width == WIDTH, "Board's width should be 5")
        assert(board.height == HEIGHT, "Board's height should be 10")
        assert(board.cells.length == WIDTH*HEIGHT, "Board #rows should be 10")
        assert(board.cells(0) !== None, "Board rows should be initialized")
    }

    test("A created 10 x 5 board should have the correct dimensions") {
        val WIDTH : Int = 10;
        val HEIGHT : Int = 5;

        val board : Board = new Board(WIDTH, HEIGHT)

        assert(board.width == WIDTH, "Board's width should be 5")
        assert(board.height == HEIGHT, "Board's height should be 10")
        assert(board.cells.length == WIDTH*HEIGHT, "Board #rows should be 5")
        assert(board.cells(0) !== None, "Board rows should be initialized")
    }

    test("Board() A 10 x 10 randomized board should not throw exceptions") {
        val WIDTH : Int = 10;
        val HEIGHT : Int = 5;
        val RANDOMIZED : Boolean = true

        val board : Board = new Board(WIDTH, HEIGHT, RANDOMIZED)

    }

    test ("getCellIndex() Cell at board.cells(0)(0) should be at cellIndex=0") {
        val board = new Board(5, 10)
        val x = 0
        val y = 0

        assert(board.getCellIndex(x, y) == 0)
        assert(board.getCell(0) == board.cells(0))

    }

    test ("getNeighborsAtIndex() [5x10 Board] Number of neighbors of Cell at cellIndex=0 should be 3") {
        val board = new Board(5, 10)
        val CELL_INDEX = 0

        assert(board.getNeighborsAtIndex(CELL_INDEX).length == 3)

    }

    test ("getNeighborsAtIndex() [5x10 Board] Number of neighbors of Cell at cellIndex=1 should be 5") {
        val board = new Board(5, 10)
        val CELL_INDEX = 1

        assert(board.getNeighborsAtIndex(CELL_INDEX).length == 5)

    }

    test ("getNeighborsAtIndex() [5x10 Board] Number of neighbors of Cell at cellIndex=6 should be 8") {
        val board = new Board(5, 10)
        val CELL_INDEX = 6

        assert(board.getNeighborsAtIndex(CELL_INDEX).length == 8)

    }

    test ("getNeighborsAtIndex() [5x10 Board] Number of neighbors of Cell at cellIndex=49 should be 3") {
        val board = new Board(5, 10)
        val CELL_INDEX = 49

        assert(board.getNeighborsAtIndex(CELL_INDEX).length == 3)

    }

    test ("createFromString() [5x5 Board] Creating all alive cells.") {
        val EXPECTED_STRING =
            "11111\n" +
            "11111\n" +
            "11111\n" +
            "11111\n" +
            "11111\n"

        val inputString = EXPECTED_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        println(outputString)
        println(EXPECTED_STRING)

        assert(EXPECTED_STRING == outputString)

    }

    test ("createFromString() [5x5 Board] Creating all dead cells.") {
        val EXPECTED_STRING =
            "00000\n" +
                    "00000\n" +
                    "00000\n" +
                    "00000\n" +
                    "00000\n"

        val inputString = EXPECTED_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("createFromString() [5x5 Board] Some dead, some alive.") {
        val EXPECTED_STRING =
            "00001\n" +
                    "10000\n" +
                    "00100\n" +
                    "00000\n" +
                    "10010\n"

        val inputString = EXPECTED_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("createFromString() [5x5 Board] Some empties unspecified") {
        val INPUT_STRING =
            "00001\n" +
                    "10\n" +
                    "0010\n" +
                    "\n" +
                    "10010\n"

        val EXPECTED_STRING =
            "00001\n" +
                    "10000\n" +
                    "00100\n" +
                    "00000\n" +
                    "10010\n"

        val inputString = INPUT_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("createFromString() [15x15 Board] Create a Pulsar board") {
        val EXPECTED_STRING =
            "000000000000000" + "\n" +
                    "000111000111000" + "\n" +
                    "000000000000000" + "\n" +
                    "010000101000010" + "\n" +
                    "010000101000010" + "\n" +
                    "010000101000010" + "\n" +
                    "000111000111000" + "\n" +
                    "000000000000000" + "\n" +
                    "000111000111000" + "\n" +
                    "010000101000010" + "\n" +
                    "010000101000010" + "\n" +
                    "010000101000010" + "\n" +
                    "000000000000000" + "\n" +
                    "000111000111000" + "\n" +
                    "000000000000000" + "\n"

        val inputString = EXPECTED_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("simulate() [4x4 Board] [Still-Life] Block: Simulate 1 step.") {
        val EXPECTED_STRING =
            "0000\n" +
                    "0110\n" +
                    "0110\n" +
                    "0000\n"


        val inputString = EXPECTED_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        board.simulate()
        var outputString = board.printString()
        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("simulate() [5x5 Board] [Oscillators] Blinker: Simulate 1 step.") {
        val STARTING_STRING =
            "00000\n" +
                    "00000\n" +
                    "01110\n" +
                    "00000\n" +
                    "00000\n"

        val EXPECTED_STRING =
            "00000\n" +
                    "00100\n" +
                    "00100\n" +
                    "00100\n" +
                    "00000\n"


        val inputString = STARTING_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)
        board.simulate()
        var outputString = board.printString()

        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")

        assert(EXPECTED_STRING == outputString)
    }

    test ("simulate() [5x5 Board] [Bottom Pattern] Simulate 1 step.") {
        val STARTING_STRING =
            "00000\n" +
            "01010\n" +
            "00110\n"

        val EXPECTED_STRING =
            "00000\n" +
            "00010\n" +
            "01010\n"


        val inputString = STARTING_STRING.replace(TestBoard.STRING_DEAD, Cell.STRING_DEAD).replace(TestBoard.STRING_ALIVE, Cell.STRING_ALIVE)
        val board = Board.createFromString(inputString)

        val cells = board.cells

        assert(!cells(11).alive, "Before simulate, Cell 11  should be dead")
        assert(!cells(7).alive, "Before simulate, Cell 7  should be dead")
        assert(board.getAliveNeighborsAtIndex(7).length == 4, "Before simulate, Cell 7 should have 4 alive neighbors")
        assert(board.getAliveNeighborsAtIndex(11).length == 2, "Before simulate, Cell 11 should have 2 alive neighbors")

        board.simulate()

        var outputString = board.printString()

        outputString = outputString.replace(Cell.STRING_DEAD, TestBoard.STRING_DEAD).replace(Cell.STRING_ALIVE, TestBoard.STRING_ALIVE).replace(" ", "")
        println("START:")
        println(inputString)
        println("EXPECTED")
        println(EXPECTED_STRING)
        println("ACTUAL")
        println(outputString)

        assert(EXPECTED_STRING == outputString)
    }

}
