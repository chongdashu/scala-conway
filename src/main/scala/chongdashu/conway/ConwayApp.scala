package scala.chongdashu.conway

import chongdashu.conway.Board

/**
  * Created by Chong-U Lim on 29 Jun 2016
  */
object ConwayApp {

    def main(args : Array[String]) : Unit = {
        println("Hello, Scala Conway Project!")
        val board = Board(10, 10, true)

        println(board.printString())

    }

}
