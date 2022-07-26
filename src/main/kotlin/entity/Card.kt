package entity

/**
 * Data class for the single typ of game elements that the game "Swim" knows: cards.
 *
 * It is characterized by a [CardValue] and a [CardSuit].
 */
open class Card(val suit :CardSuit, val value : CardValue){

    override fun toString(): String = "$suit$value"
}