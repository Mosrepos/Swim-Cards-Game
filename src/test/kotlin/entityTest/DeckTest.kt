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

    // decks to use for testing

    private val d1 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.DIAMONDS, CardValue.ACE),
                Card(CardSuit.DIAMONDS, CardValue.JACK)
            )
        )
    )


    private val d3 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.DIAMONDS, CardValue.QUEEN),
                Card(CardSuit.DIAMONDS, CardValue.KING),
                Card(CardSuit.DIAMONDS, CardValue.TEN)
            )
        )
    )


    /**
     * Test if shuffle works correctly
     */
    @Test
    fun testShuffle() {
        val d3Copy = d3.copy()
        val random = Random(42)
        d3Copy.shuffle(random)
        val shuffled_d3copy = d3Copy.cards
        print(shuffled_d3copy.toString())
        assert(shuffled_d3copy[0].value == CardValue.KING)
        assert(shuffled_d3copy[0].suit == CardSuit.DIAMONDS)
        assert(shuffled_d3copy[1].value == CardValue.QUEEN)
        assert(shuffled_d3copy[1].suit == CardSuit.DIAMONDS)
        assert(shuffled_d3copy[2].value == CardValue.TEN)
        assert(shuffled_d3copy[2].suit == CardSuit.DIAMONDS)

    }

    /**
     * Test if drawThreeCards works correctly
     */
    @Test
    fun testDrawThreeCards(){

        assertFailsWith<IllegalArgumentException> { d1.drawThreeCards() }


        val drawnCards = d3.drawThreeCards()
        assert(drawnCards[0].value == CardValue.QUEEN)
        assert(drawnCards[0].suit == CardSuit.DIAMONDS)
        assert(drawnCards[1].value == CardValue.KING)
        assert(drawnCards[1].suit == CardSuit.DIAMONDS)
        assert(drawnCards[2].value == CardValue.TEN)
        assert(drawnCards[2].suit == CardSuit.DIAMONDS)

    }

    /**
     * test if toString method works correctly
     */
    @Test
    fun testToString() {
        assert(d1.toString() == "[♦A, ♦J]")

    }
}