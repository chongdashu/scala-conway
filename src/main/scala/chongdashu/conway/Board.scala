package chongdashu.conway

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by culim on 6/30/16.
  */
case class Board(width : Integer, height : Integer, randomizeCells : Boolean = false) {

    var generation : Int = 0

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
    val cells : Array[Array[Cell]] = new Array[Array[Cell]](height)
    for (i  <- 0 to (cells.length-1)) {
        cells(i) = new Array(width)
        for (j <- 0 to (cells(i).length-1)) {
            val index = i*width + j
            cells(i)(j) = Cell(index, if (randomizeCells) Random.nextBoolean() else false)
        }
    }

    def getCell(cellIndex : Int) : Cell = {
        val cellYX = getCellYX(cellIndex)
        return cells(cellYX._1)(cellYX._2)
    }

    def getNeighborsAtIndex(cellIndex : Int): Array[Cell] = {
        val offsets : List[Tuple2[Int, Int]] = List(
            (-1, -1), (0, -1), (+1, -1),
            (-1, +0),          (+1, +0),
            (-1, +1), (0, +1), (+1, +1)
        )

        val neighbors = new ListBuffer[Cell]

        val (x, y) = getCellXY(cellIndex)


        for ((offsetX, offsetY)<- offsets) {
            val (neighborX, neighborY) = (x+offsetX, y+offsetY)
            if (isValidLocation(neighborX, neighborY)) {
                neighbors += cells(neighborY)(neighborX)
            }
        }

        return neighbors.toArray
    }

    def getCellYX(cellIndex : Int) : (Int, Int) = {
        return (cellIndex / width, cellIndex % width)
    }

    def getCellXY(cellIndex : Int) : (Int, Int) = {
        return (cellIndex % width, cellIndex / width)
    }

    def getCellIndex(x : Int, y : Int) : Int = {
        return y * width + x
    }

    def isValidLocation(x : Int, y : Int): Boolean = {
        return (x >= 0 && x < width && y >= 0 && y < height)
    }

    def simulate() : Unit = {

    }

    def printString() : String = {
        var str = ""
        for (row <- cells) {
            for (col <- row) {
                str += col.printString()
                str += " "
            }
            str += "\n"
        }

        return str
    }

}


