package entity

import kotlin.test.*

/**
 * test class to test [Player]
 *
 */
class PlayerTest {
    private val deck1 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.DIAMONDS, CardValue.QUEEN),
                Card(CardSuit.DIAMONDS, CardValue.KING),
                Card(CardSuit.DIAMONDS, CardValue.TEN)
            )
        )
    )
    private val deck2 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.HEARTS, CardValue.QUEEN),
                Card(CardSuit.HEARTS, CardValue.KING),
                Card(CardSuit.HEARTS, CardValue.TEN)
            )
        )
    )
    val player1 = Player("Mo",deck1)
    val player2 = Player("Luca",deck2)


    /**
     * funtion to test the parameters of a [Player]
     */
    @Test
    fun testPlayer(){
        assert(player1.playerName == "Mo")
        assert(player1.playerHand == deck1)
        assert(player2.playerName == "Luca")
        assert(player2.playerHand == deck2)

    }

}