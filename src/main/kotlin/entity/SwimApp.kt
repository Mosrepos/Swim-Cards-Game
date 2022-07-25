package entity

import java.util.*

open class SwimApp (){
    open var drawPile = Deck()
    open var tableDeck = Deck()
    open var passes = 0
    open var currentPlayer = Player(name = "player1")
    open var calledPlayer = Player(name = "player2")
}