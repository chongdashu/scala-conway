package scala.chongdashu.conway

import chongdashu.conway.{Cell, Board}

/**
  * Created by Chong-U Lim on 29 Jun 2016
  */
object ConwayApp {

    def main(args : Array[String]) : Unit = {
        println("Hello, Scala Conway Project!")
        var boardString =
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
            "000000000000000"

        boardString = boardString.replace("0", Cell.STRING_DEAD).replace("1", Cell.STRING_ALIVE)

        val board = Board.createFromString(boardString)

        println(board.printString())

        var lastUpdate = System.currentTimeMillis()
        val INTERVAL_MSEC = 250
        while (true) {
            if (System.currentTimeMillis() - lastUpdate >= INTERVAL_MSEC) {
                lastUpdate = System.currentTimeMillis()
                board.simulate()
                println(board.printString())
            }
            else {
                Thread.sleep(Math.min(1,Math.max(100, INTERVAL_MSEC/10)))
            }

        }

    }

}
