package chongdashu.conway

/**
  * Created by culim on 6/30/16.
  */
case class Cell (var alive : Boolean = false) {

    var aliveNext = false

    def printString() : String = {
        if (alive) return Cell.STRING_ALIVE else return Cell.STRING_DEAD
    }
}

object Cell {
    val STRING_ALIVE = "*"
    val STRING_DEAD = "."



    // def apply(alive: Boolean = false)

//    def createFromString(cellString : String) : Cell = {
//
//        return new Cell(-1, cellString==STRING_ALIVE)
//    }
}
