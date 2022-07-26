package entity

/**
 * Entity to represent a player in the game "Swim". It has a [playerName] and the information
 * which deck the player has
 */

open class Player (val name : String){

    val playerHand = Deck()
    val playerName = name

}