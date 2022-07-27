package entity

/**
 * Data class for the single typ of game elements that the game "Swim" knows: cards.
 *
 * It is characterized by a [CardValue] and a [CardSuit].
 *
 * @param [suit] is the color of the card
 * @param [value] is the value of the card
 */
data class Card(val suit :CardSuit, val value : CardValue){

    public fun valueOf() = when (value) {
        CardValue.SEVEN -> 7
        CardValue.EIGHT -> 8
        CardValue.NINE -> 9
        CardValue.TEN -> 10
        CardValue.JACK -> 10
        CardValue.QUEEN -> 10
        CardValue.KING -> 10
        CardValue.ACE -> 11
    }

    override fun toString(): String = "$suit$value"
}