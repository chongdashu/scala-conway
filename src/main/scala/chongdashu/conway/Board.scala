package chongdashu.conway

/**
  * Created by culim on 6/30/16.
  */
case class Board(width : Integer, height : Integer) {

    /**
      * The internal representation of the board is
      * an array of array of Cells.
      *
      * The convention used is the origin in the top-left
      * corner of the board.
      *
      * | (0,0) | (0, 1) | (0, 2) | ... | (0, width)
      * | (1,0) | (1, 1) | (1, 2) | ... | (1, width)
      * | ...
      * | (h, 0) | (h, 1) | (h, 2) | ... | (h, width)
      *
      */
    val cells = new Array[Array[Cell]](height)
    for (i  <- 0 to (cells.length-1)) {
        cells(i) = new Array(width)
    }

    def printString() : String = {
        var str = ""
        return str
    }

}


