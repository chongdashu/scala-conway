package chongdashu.conway

/**
  * Created by culim on 6/30/16.
  */
case class Cell (val index : Int, var alive : Boolean = false) {


    def printString() : String = {
        if (alive) return Cell.STRING_ALIVE else return Cell.STRING_DEAD
    }
}

object Cell {
    val STRING_ALIVE = "*"
    val STRING_DEAD = " "

    // def apply(alive: Boolean = false)
}
