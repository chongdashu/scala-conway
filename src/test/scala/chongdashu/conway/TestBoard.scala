package chongdashu.conway

import org.scalatest.FunSuite

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
        assert(board.cells.length == HEIGHT, "Board #rows should be 10")
        assert(board.cells(0) !== None, "Board rows should be initialized")
        assert(board.cells(0).length == WIDTH, "Board #columns should be 10")
    }

    test("A created 5 x 10 board should have the correct dimensions") {
        val WIDTH : Int = 5;
        val HEIGHT : Int = 10;

        val board : Board = new Board(WIDTH, HEIGHT)

        assert(board.width == WIDTH, "Board's width should be 5")
        assert(board.height == HEIGHT, "Board's height should be 10")
        assert(board.cells.length == HEIGHT, "Board #rows should be 10")
        assert(board.cells(0) !== None, "Board rows should be initialized")
        assert(board.cells(0).length == WIDTH, "Board #columns should be 5")
    }

    test("A created 10 x 5 board should have the correct dimensions") {
        val WIDTH : Int = 10;
        val HEIGHT : Int = 5;

        val board : Board = new Board(WIDTH, HEIGHT)

        assert(board.width == WIDTH, "Board's width should be 5")
        assert(board.height == HEIGHT, "Board's height should be 10")
        assert(board.cells.length == HEIGHT, "Board #rows should be 5")
        assert(board.cells(0) !== None, "Board rows should be initialized")
        assert(board.cells(0).length == WIDTH, "Board #columns should be 10")
    }

    test("A 10 x 10 randomized board should not throw exceptions") {
        val WIDTH : Int = 10;
        val HEIGHT : Int = 5;
        val RANDOMIZED : Boolean = true

        val board : Board = new Board(WIDTH, HEIGHT, RANDOMIZED)

    }

    test ("Cell at board.cells(0)(0) should be at cellIndex=0") {
        val board = new Board(5, 10)
        val x = 0
        val y = 0

        assert(board.getCellIndex(x, y) == 0)
        assert(board.getCell(0) == board.cells(0)(0))

    }

    test ("Number of neighbors of Cell at cellIndex=0 should be 3") {
        val board = new Board(5, 10)
        val CELL_INDEX = 0

        assert(board.getNeighborsAtIndex(CELL_INDEX).length == 3)

    }

}
