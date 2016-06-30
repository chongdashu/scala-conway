package chongdashu.conway

import org.scalatest.FunSuite

/**
  * Created by culim on 6/30/16.
  */
class TestCell extends FunSuite {

    test("A Cell created with the default constructor should NOT be alive") {
        val cell = Cell()
        assert(!cell.alive)
    }

    test("A Cell created with alive=True specified should be alive") {
        val cell = Cell(true)
        assert(cell.alive)
    }

    test("A Cell created with the alive=True constructor should NOT be alive") {
        val cell = Cell(false)
        assert(!cell.alive)
    }

}
