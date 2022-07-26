package entity

/**
 * Entity to represent a player in the game "Swim". It has a [playerName] and the information
 * which deck the player has
 *
 * @param [playerName] is the name of the player
 * @param [playerHand] is the deck of the player containing 3 cards
 */

data class Player (val playerName: String, var playerHand: Deck)