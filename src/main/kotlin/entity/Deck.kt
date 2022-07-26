package entity

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.random.Random

open class Deck(private val random : Random = Random){

    /**
     * The actual backing data structure. As there is no dedicated stack implementation
     * in Kotlin, a "double-ended queue" (Deque) is used.
     */
     val cards: ArrayDeque<Card> = ArrayDeque(32)


    /**
     * Shuffles the cards in this stack
     */
    fun shuffle() {
        cards.shuffle(random)
    }

    /**
     * Draws [amount] cards from this stack.
     *
     * @param amount the number of cards to draw; defaults to 1 if omitted.
     *
     * @throws IllegalArgumentException if not enough cards on stack to draw the desired amount.
     */
    fun drawThreeCards(amount: Int = 3): List<Card> {
        require (amount in 3..cards.size) { "can't draw $amount cards from $cards" }
        return List(amount) { cards.removeFirst() }
    }

    override fun toString(): String = cards.toString()

}