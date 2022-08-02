package view

import entity.Card
import entity.CardSuit
import entity.CardValue
import entity.Deck
import service.CardImageLoader
import service.RootService
import tools.aqua.bgw.components.container.GameComponentContainer
import tools.aqua.bgw.components.container.LinearLayout
import tools.aqua.bgw.components.gamecomponentviews.CardView
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.util.BidirectionalMap
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual
import tools.aqua.bgw.visual.ImageVisual

class SwimScene(private val rootService: RootService) : Refreshable, BoardGameScene(1920, 1080) {


    //private var playerCard = game.currentPlayer.playerHand.cards[0]
    //private var tableCard = game.tableDeck.cards[0]

    //private val Hand1 =

    /**
    private fun displayOtherPlayers() = when(game.players.size) {
    2 -> {

    }
    3 -> {

    }
    4 -> {

    }
    }
     */
    private val tableCards = LinearLayout<CardView>(
        posX = 668, posY = 350,width = 500,height = 200, spacing = 5
    )
    private val currentPlayerCards = LinearLayout<CardView>(
        posX = 668, posY = 800,width = 500,height = 200, spacing = 5
    )

    private val image = CardImageLoader()
    private val pile = CardView(
        front = ImageVisual(image.backImage),posX = 5, posY = 600
    )

    private val swapAll = Button(
        width = 300, height = 50, posX = 1600, posY = 800,
        text = "Swap All Cards"
    ).apply {
        visual = ColorVisual(0, 255, 0)
        onMouseClicked = {
            rootService.playerService.swapAllCards()
        }
    }
    private val swapOne = Button(
        width = 300, height = 50, posX = 1600, posY = 855,
        text = "Swap One Card"
    ).apply {
        visual = ColorVisual(255, 91, 91)
        onMouseClicked = {
            //player.swapOneCard(playerCard,tableCard)
        }
    }
    private val call = Button(
        width = 300, height = 50, posX = 1600, posY = 910,
        text = "Call"
    ).apply {
        visual = ColorVisual(255, 91, 91)
        onMouseClicked = {
            rootService.playerService.call()
        }
    }
    private val pass = Button(
        width = 300, height = 50, posX = 1600, posY = 965,
        text = "Pass"
    ).apply {
        visual = ColorVisual(255, 91, 91)
        onMouseClicked = {
            rootService.playerService.pass()
        }
    }
    private val yourScore = Label(
        width = 300, height = 50, posX = 800, posY = 700,
        //text = "your Score:${(rootService.playerService.calculatePoints(rootService.currentGame.currentPlayer)).toString()}",
        font = Font(size = 22)
    )

    private val cardMap: BidirectionalMap<Card, CardView> = BidirectionalMap()

    init {
        background = ColorVisual(108, 168, 59)
        addComponents(swapAll, swapOne, call, pass, yourScore, tableCards, currentPlayerCards,pile)
    }

    override fun refreshAfterStartGame() {
        cardMap.clear()
        val cardImageLoader = CardImageLoader()
        initializeDeckView(rootService.currentGame.tableDeck,tableCards,cardImageLoader)
        initializeDeckView(rootService.currentGame.currentPlayer.playerHand,currentPlayerCards,cardImageLoader)
    }

    override fun refreshAfterPlayerChange() {
        cardMap.clear()
        val cardImageLoader = CardImageLoader()
        initializeDeckView(rootService.currentGame.tableDeck,tableCards,cardImageLoader)
        initializeDeckView(rootService.currentGame.currentPlayer.playerHand,currentPlayerCards,cardImageLoader)
    }

    /**
     * clears [gameComponentContainer], adds a new [CardView] for each
     * element of [Deck] onto it, and adds the newly created view/card pair
     * to the global [cardMap].
     */
    private fun initializeDeckView(
        deck: Deck,
        gameComponentContainer: GameComponentContainer<CardView>,
        cardImageLoader: CardImageLoader
    ) {
        gameComponentContainer.clear()
        deck.cards.reversed().forEach { card ->
            val cardView = CardView(
                height = 200,
                width = 130,
                front = ImageVisual(cardImageLoader.frontImageFor(card.suit, card.value)),
                back = ImageVisual(cardImageLoader.backImage)
            )
            gameComponentContainer.add(cardView)
            cardMap.add(card to cardView)
            cardView.showFront()
        }
    }

    // 2 cards for swapOneCard
    private var card1: Card? = null
    private var card2: Card? = null

    private fun addCardListeners(linearLayout: LinearLayout<CardView>) {
        linearLayout.forEach {
            it.apply {
                onMouseClicked = {
                    if (card1 == null) {
                        card1 = cardMap.backward(this)
                        posY = -20.0
                    } else {
                        if (card2 == null) {
                            card2 = cardMap.backward(this)
                            posY = -20.0
                        }
                    }
                }
            }
        }
    }
}