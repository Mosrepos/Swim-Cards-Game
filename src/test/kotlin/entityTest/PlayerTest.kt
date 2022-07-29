package entityTest


import entity.*
import kotlin.test.Test

/**
 * test class to test Player
 *
 */
class PlayerTest {

    /**
     * function to test the parameters of a Player
     */
    @Test
    fun testPlayer(){


        var deck1 = Deck()
        val c1 = Card(CardSuit.SPADES, CardValue.ACE)
        val c2 = Card(CardSuit.DIAMONDS, CardValue.JACK)
        deck1.cards.add(c1)
        deck1.cards.add(c2)

        var deck2 = Deck()
        val c3 = Card(CardSuit.DIAMONDS, CardValue.TEN)
        val c4 = Card(CardSuit.DIAMONDS, CardValue.KING)
        val c5 = Card(CardSuit.DIAMONDS, CardValue.QUEEN)
        deck2.cards.add(c3)
        deck2.cards.add(c4)
        deck2.cards.add(c5)

        var player1 = Player("Mo", deck1)
        var player2 = Player("Luca", deck2)

        assert(player1.name == "Mo")
        assert(player1.playerHand == deck1)
        assert(player2.name == "Luca")
        assert(player2.playerHand == deck2)


    }
}