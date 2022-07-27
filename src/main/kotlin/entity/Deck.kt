package entity


import kotlin.random.Random

/**
 * The actual backing data structure. As there is no dedicated stack implementation
 * in Kotlin, a "double-ended queue" (Deque) is used.
 */
data class Deck(val cards: ArrayDeque<Card> = ArrayDeque(3)){
    /**
     * Holds cards in [cards]. A Deck is used to represent a card stack or a players hand in the swim game.
     */


    /**
     * Shuffles the cards in this stack
     */
    fun shuffle(random: Random = Random) {
        cards.shuffle(random)
    }

    /**
     * Removes 3 cards from the deck and returns them
     *
     * @return a List of 3 cards
     * @throws IllegalArgumentException if less than 3 cards are in the [Deck]
     */
    fun drawThreeCards(): List<Card> {
        require (cards.size >= 3) { "not enough cards" }
        return List(3) { cards.removeFirst() }
    }


    /**
     * Creates a String representing this Deck
     *
     * @return String representing this Deck
     */
    override fun toString(): String = cards.toString()

}