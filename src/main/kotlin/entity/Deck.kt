package entity

import java.util.*
import kotlin.collections.ArrayDeque

open class Deck(){

    private val cards: ArrayDeque<Card> = ArrayDeque(32)

    var sizeOfDeck = cards.size

/* create lists of cards
    var playerHand = TODO()
    var drawPile =  TODO()
    var tableDeck = TODO()
  */
}