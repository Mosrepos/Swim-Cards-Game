package entity

/**
 * Entity to represent a player in the game "Swim". It has a [name] and the information
 * which deck the player has
 *
 * @param [name] is the name of the player
 * @param [playerHand] is the deck of the player containing 3 cards
 */

data class Player(val name: String, var playerHand: Deck = Deck())