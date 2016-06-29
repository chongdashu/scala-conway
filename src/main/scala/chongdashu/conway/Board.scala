package chongdashu.conway

/**
  * Created by culim on 6/30/16.
  */
case class Board(width : Integer, height : Integer) {

    val cells = new Array[Array[Cell]](height)
    for (i  <- 0 to (cells.length-1)) {
        cells(i) = new Array(width);
    }

}


