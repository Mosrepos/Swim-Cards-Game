package entity

import kotlin.test.*

/**
 * test class to test the [SwimApp]
 *
 */
class SwimAppTest{

    private val pile = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.DIAMONDS, CardValue.QUEEN),
                Card(CardSuit.DIAMONDS, CardValue.KING),
                Card(CardSuit.DIAMONDS, CardValue.TEN)
            )
        )
    )
    private val d2 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.HEARTS, CardValue.QUEEN),
                Card(CardSuit.HEARTS, CardValue.KING),
                Card(CardSuit.HEARTS, CardValue.TEN)
            )
        )
    )
    private val d3 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.SPADES, CardValue.QUEEN),
                Card(CardSuit.SPADES, CardValue.KING),
                Card(CardSuit.SPADES, CardValue.TEN)
            )
        )
    )
    private val table = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.CLUBS, CardValue.QUEEN),
                Card(CardSuit.CLUBS, CardValue.KING),
                Card(CardSuit.CLUBS, CardValue.TEN)
            )
        )
    )
    private val d1 = Deck(
        ArrayDeque(
            listOf(
                Card(CardSuit.SPADES, CardValue.SEVEN),
                Card(CardSuit.SPADES, CardValue.NINE),
                Card(CardSuit.SPADES, CardValue.EIGHT)
            )
        )
    )

    val p1 = Player("Mo",d1)
    val p2 = Player("Hasan",d2)
    val p3 = Player("Safi",d3)
    val playersList = listOf<Player>(p1,p2,p3)
    var currentPlayer = p1
    val calledPlayer = currentPlayer
    var passes: Int = 0

    /**
     * a funtion to test the parameters of the [SwimApp]
     */
    @Test
    fun testSwimApp(){
        assert(playersList[0]==p1)
        assert(playersList[1]==p2)
        assert(playersList[2]==p3)

        assert(currentPlayer==p1)
        assert(calledPlayer==p1)
        assert(passes==0)

        val pileCopy = pile.copy()
        assert(pileCopy==pile)


        val tableCopy = table.copy()
        assert(tableCopy==table)

    }


}