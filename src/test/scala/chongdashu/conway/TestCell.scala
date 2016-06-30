package chongdashu.conway

import org.scalatest.FunSuite

/**
  * Created by culim on 6/30/16.
  */
class TestCell extends FunSuite {

    test("A Cell created with the default constructor should NOT be alive") {
        val cell = Cell(0)
        assert(!cell.alive)
    }

    test("A Cell created with alive=True specified should be alive") {
        val cell = Cell(0, true)
        assert(cell.printString()==Cell.STRING_ALIVE)
    }


    test ("A cell should print its STRING_ALIVE string if alive") {
        val cell = Cell(0, true)
        assert(cell.printString() == Cell.STRING_ALIVE)
    }

    test ("A cell should print its STRING_DEAD string if dead") {
        val cell = Cell(0, false)
        assert(cell.printString() == Cell.STRING_DEAD)
    }


}
