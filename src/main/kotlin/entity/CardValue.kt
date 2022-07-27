package entity

import java.util.*

/**
 * Enum to distinguish between the 8 possible values in a french-suited card game:
 * 7-10, Jack, Queen, King, and Ace.
 *
 * The values are ordered according to their most common ordering:
 * 7 < ... < 10 < Jack < Queen < King < Ace
 *
 */
enum class CardValue {
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    JACK,
    QUEEN,
    KING,
    ACE,
    ;

    /**
     * provide a single character to represent this value.
     * Returns one of: 7/8/9/10/J/Q/K/A
     */
    override fun toString() =
        when(this) {
            SEVEN -> "7"
            EIGHT -> "8"
            NINE -> "9"
            TEN -> "10"
            JACK -> "J"
            QUEEN -> "Q"
            KING -> "K"
            ACE -> "A"
        }


    companion object {

        /**
         * A set of values for a reduced set of 4x8=32 cards (starting with the 7)
         */
        fun shortDeck(): Set<CardValue> {
            return EnumSet.of(ACE, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING)
        }

    }


    /**
     * @return the value
     */
    fun valueOf() = when (this) {
        SEVEN -> 7
        EIGHT -> 8
        NINE -> 9
        TEN -> 10
        JACK -> 10
        QUEEN -> 10
        KING -> 10
        ACE -> 11
    }


}