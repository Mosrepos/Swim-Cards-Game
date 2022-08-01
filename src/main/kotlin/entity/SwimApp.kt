package entity


/**
 * creates a game of "Swim".
 */

class SwimApp(
    var players: List<Player> = listOf(Player("player1"), Player("player2")),
    val drawPile: Deck = Deck(),
    var tableDeck: Deck = Deck()
) {
    var currentPlayer = players[0]
    var calledPlayer: Player? = null
    var passes: Int = 0
}