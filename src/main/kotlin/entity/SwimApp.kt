package entity

/**
 * creates a game of "Swim".
 */

data class SwimApp (
    var currentPlayer: Player,
    var calledPlayer: Player? = null,
    var passes: Int = 0,
    val players: List<Player>,
    val drawPile: Deck,
    val tableDeck: Deck,
        )