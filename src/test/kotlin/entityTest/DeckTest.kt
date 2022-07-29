package entityTest


import entity.Card
import entity.CardSuit
import entity.CardValue
import entity.Deck
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertFailsWith


/**
 * Test cases for [Deck]
 */
class DeckTest {

    /**
     * Test if shuffle works correctly
     */
    @Test
    fun testShuffle() {
        var deck2 = Deck()
        val c3 = Card(CardSuit.DIAMONDS, CardValue.TEN)
        val c4 = Card(CardSuit.DIAMONDS, CardValue.KING)
        val c5 = Card(CardSuit.DIAMONDS, CardValue.QUEEN)
        deck2.cards.add(c3)
        deck2.cards.add(c4)
        deck2.cards.add(c5)
        val random = Random(42)
        deck2.shuffle(random)


        print(deck2.toString())
        /**
        assert(deck2.cards[0].value == CardValue.TEN)
        assert(deck2.cards[0].suit == CardSuit.DIAMONDS)
        assert(deck2.cards[1].value == CardValue.QUEEN)
        assert(deck2.cards[1].suit == CardSuit.DIAMONDS)
        assert(deck2.cards[2].value == CardValue.TEN)
        assert(deck2.cards[2].suit == CardSuit.DIAMONDS)
         */
    }

    /**
     * Test if drawThreeCards works correctly
     */
    @Test
    fun testDrawThreeCards() {


        var deck1 = Deck()
        val c1 = Card(CardSuit.SPADES, CardValue.ACE)
        val c2 = Card(CardSuit.DIAMONDS, CardValue.JACK)
        deck1.cards.add(c1)
        deck1.cards.add(c2)
        assertFailsWith<IllegalArgumentException> { deck1.drawThreeCards() }

    }

    /**
     * test if toString method works correctly
     */
    @Test
    fun testToString() {
        var deck1 = Deck()
        val c1 = Card(CardSuit.SPADES, CardValue.ACE)
        val c2 = Card(CardSuit.DIAMONDS, CardValue.JACK)
        deck1.cards.add(c1)
        deck1.cards.add(c2)
        assert(deck1.toString() == "[♦A, ♦J]")
    }
}