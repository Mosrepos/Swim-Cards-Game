package entity


/**
 * creates a game of "Swim".
 */

class SwimApp {
    var currentPlayer = Player()
    var calledPlayer: Player? = null
    var passes: Int = 0
    val players = listOf<Player>(Player(), Player())
    val drawPile: Deck = Deck()
    val tableDeck: Deck = Deck()
}