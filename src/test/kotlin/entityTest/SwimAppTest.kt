package entityTest


import entity.*
import kotlin.test.Test

/**
 * test class to test the [SwimApp]
 *
 */
class SwimAppTest {

    /**
     * a function to test the parameters of the [SwimApp]
     */
    @Test
    fun testSwimApp(){

        val d1 = Deck()
        d1.cards.add(Card(CardSuit.SPADES, CardValue.ACE))
        val d2 = Deck()
        val d3 = Deck()
        val p1 = Player("Mo", d1)
        val p2 = Player("Hasan", d2)
        val p3 = Player("Safi", d3)
        val playersList = listOf(p1, p2, p3)

        var passes: Int = 0

        val game1 = SwimApp(playersList, d1, d2)
        game1.currentPlayer = p1
        game1.calledPlayer = p2


        assert(game1.currentPlayer == p1)
        assert(game1.calledPlayer == p2)


        assert(playersList[0] == p1)
        assert(playersList[1] == p2)
        assert(playersList[2] == p3)


    }
}