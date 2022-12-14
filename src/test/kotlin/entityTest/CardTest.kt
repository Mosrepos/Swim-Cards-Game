package entityTest


import entity.Card
import entity.CardSuit
import entity.CardValue
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotSame

/**
 * Test cases for [Card]
 */
class CardTest {

    // Some cards to perform the tests with
    private val aceOfSpades = Card(CardSuit.SPADES, CardValue.ACE)
    private val jackOfClubs = Card(CardSuit.CLUBS, CardValue.JACK)
    private val queenOfHearts = Card(CardSuit.HEARTS, CardValue.QUEEN)
    private val otherQueenOfHearts = Card(CardSuit.HEARTS, CardValue.QUEEN)
    private val jackOfDiamonds = Card(CardSuit.DIAMONDS, CardValue.JACK)
    private val sevenOfSpades = Card(CardSuit.SPADES, CardValue.SEVEN)
    private val eightOfSpades = Card(CardSuit.SPADES, CardValue.EIGHT)
    private val nineOfSpades = Card(CardSuit.SPADES, CardValue.NINE)
    private val tenOfSpades = Card(CardSuit.SPADES, CardValue.TEN)
    private val kingOfSpades = Card(CardSuit.SPADES, CardValue.KING)


    // unicode characters for the suits, as those should be used by [Card.toString]
    private val heartsChar = '\u2665' // ♥
    private val diamondsChar = '\u2666' // ♦
    private val spadesChar = '\u2660' // ♠
    private val clubsChar = '\u2663' // ♣

    /**
     * Check if to String produces the correct strings for some test cards
     * of all four suits.
     */
    @Test
    fun testToString() {
        assertEquals(spadesChar + "A", aceOfSpades.toString())
        assertEquals(clubsChar + "J", jackOfClubs.toString())
        assertEquals(heartsChar + "Q", queenOfHearts.toString())
        assertEquals(diamondsChar + "J", jackOfDiamonds.toString())
    }

    /**
     * Check if toString produces a 2 character string for every possible card
     * except the 10 (for which length=3 is ensured)
     */
    @Test
    fun testToStringLength() {
        CardSuit.values().forEach { suit ->
            CardValue.values().forEach { value ->
                if (value == CardValue.TEN)
                    assertEquals(3, Card(suit, value).toString().length)
                else
                    assertEquals(2, Card(suit, value).toString().length)
            }
        }
    }


    /**
     * Check if two cards with the same CardSuit/CardValue combination are equal
     * in the sense of the `==` operator, but not the same in the sense of
     * the `===` operator.
     */
    @Test
    fun testEquals() {
        assertEquals(queenOfHearts, otherQueenOfHearts)
        assertNotSame(queenOfHearts, otherQueenOfHearts)
    }

    /**
     * test if valueOf returns the right value of a card
     */
    @Test
    fun testValueOf() {
        assert(sevenOfSpades.value.valueOf() == 7)
        assert(eightOfSpades.value.valueOf() == 8)
        assert(nineOfSpades.value.valueOf() == 9)
        assert(tenOfSpades.value.valueOf() == 10)
        assert(jackOfClubs.value.valueOf() == 10)
        assert(queenOfHearts.value.valueOf() == 10)
        assert(kingOfSpades.value.valueOf() == 10)
        assert(aceOfSpades.value.valueOf() == 11)

    }
}