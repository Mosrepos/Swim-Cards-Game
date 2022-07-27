package entityTest


import entity.*
import kotlin.test.Test

/**
 * test class to test the [SwimApp]
 *
 */
class SwimAppTest {

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
    val p3 = Player("Safi", d3)
    val playersList = listOf(p1, p2, p3)
    var currentPlayer = p1
    val calledPlayer = currentPlayer
    var passes: Int = 0

    val game1 = SwimApp(currentPlayer,calledPlayer,0,playersList,pile,table)

    /**
     * a function to test the parameters of the [SwimApp]
     */
    @Test
    fun testSwimApp(){
        assert(game1.currentPlayer == p1)
        assert(game1.calledPlayer == p1)


        assert(playersList[0]==p1)
        assert(playersList[1]==p2)
        assert(playersList[2]==p3)


    }
}