package chongdashu.conway

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

/**
  * Created by culim on 6/30/16.
  */
case class Board(width : Integer, height : Integer, randomizeCells : Boolean = false) {

    var generation : Int = 0

    val cells  = new Array[Cell](width * height)
    for (i  <- 0 to (cells.length-1)) {
        cells(i) = Cell(if (randomizeCells) Random.nextBoolean() else false)
    }

    def getCell(cellIndex : Int) : Cell = {
        return cells(cellIndex)
    }

    def getAliveNeighborsAtIndex(cellIndex : Int) : Array[Cell] = {
        return getNeighborsAtIndex(cellIndex).filter( x => x.alive )
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
                val cellIndex = getCellIndex(neighborX, neighborY)
                neighbors += cells(cellIndex)
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
        val totalCells = width * height
        for (cellIndex <- 0 to totalCells-1) {
            var cell = getCell(cellIndex)
            val aliveNeighbors = getAliveNeighborsAtIndex(cellIndex)
            if (cell.alive) {
                cell.aliveNext = (aliveNeighbors.length == 2 || aliveNeighbors.length == 3)
            }
            else {
                cell.aliveNext = aliveNeighbors.length == 3
            }

            println("cell[" + cellIndex +"], now " + cell.alive + " has " + aliveNeighbors.length + " alive neighbors: next state=" + cell.aliveNext)
        }

        for (cellIndex <- 0 to totalCells-1) {
            var cell = getCell(cellIndex)
            cell.alive = cell.aliveNext
        }
    }

    def printString() : String = {
        var str = ""

        for ((cell, cellIndex) <- cells.zipWithIndex) {

            if (cellIndex > 0 && cellIndex % width == 0) {
                str += "\n"
            }

            str += cell.printString()
            str += " "

        }

        str += "\n"

        return str
    }

}

object Board {

    def createFromString(boardString : String) : Board = {
        val rows : Array[String] = boardString.split("\\r?\\n")
        val nRows = rows.length
        val nCols = rows.map(x => x.length).reduceLeft(Math.max)

        val board = new Board(nCols, nRows)

        var cellIndex = 0
        for (row <- rows) {
            var colIndex = 0
            for (cellString <- row) {
                board.getCell(cellIndex).alive = cellString == Cell.STRING_ALIVE.charAt(0)
                cellIndex += 1
                colIndex += 1
            }
            while (colIndex < nCols) {
                colIndex += 1
                cellIndex += 1
            }
        }

        return board
    }
}


