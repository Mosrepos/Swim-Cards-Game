package entity

import entity.CardSuit
import entity.CardValue
import entity.Card
import entity.Deck
import kotlin.random.Random
import kotlin.test.*


/**
 * Test cases for [Deck]
 */
class DeckTest (){
    private val c1 = Card(CardSuit.SPADES, CardValue.ACE)
    private val c2 = Card(CardSuit.CLUBS, CardValue.JACK)
    private val c3 = Card(CardSuit.HEARTS, CardValue.QUEEN)


    /**
     * Test if shuffle works correctly
     */
    @Test
    fun testShuffle() {
        val stack = Deck(random = Random(42))
        stack.shuffle()
        assertEquals(listOf(c2,c3,c1), stack.drawThreeCards())
        assertEquals(0, stack.cards.size)
    }
}