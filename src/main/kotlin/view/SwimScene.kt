package view

import entity.Card
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

    private val hand1 = LinearLayout<CardView>(
        posX = 668, posY = 150,width = 500,height = 200, spacing = 5
    )
    private val name1 = Label(
        posX = 668,
        posY = 150,
        text = ""
    )
    private val hand2 = LinearLayout<CardView>(
        posX = 668, posY = 150,width = 500,height = 200, spacing = 5
    )
    private val name2 = Label(
        posX = 500,
        posY = 150,
        text = ""
    )
    private val hand3 = LinearLayout<CardView>(
        posX = 668, posY = 150,width = 500,height = 200, spacing = 5
    )
    private val name3 = Label(
        posX = 300,
        posY = 150,
        text = ""
    )

    private val tableCards = LinearLayout<CardView>(
        posX = 668, posY = 450,width = 500,height = 200, spacing = 5
    )
    private val currentPlayerCards = LinearLayout<CardView>(
        posX = 668, posY = 850,width = 500,height = 200, spacing = 5
    )

    private val image = CardImageLoader()
    private val pile = CardView(
        front = ImageVisual(image.backImage),posX = 10, posY = 850
    )

    private val swapAll = Button(
        width = 300, height = 50, posX = 1500, posY = 800,
        text = "Swap All Cards",
        font = Font(size = 24)
    ).apply {
        visual = ColorVisual(105, 70, 128)
        onMouseClicked = {
            rootService.playerService.swapAllCards()
        }
    }
    private var selected :CardView? = null
    private var wanted :CardView? = null



    private val swapOne = Button(
        width = 300, height = 50, posX = 1500, posY = 855,
        text = "Swap One Card",
        font = Font(size = 24)
    ).apply {
        visual = ColorVisual(214, 195, 80)
        onMouseClicked = {
            if(wanted != null && selected != null){
                rootService.playerService.swapOneCard(cardMap.backward(wanted!!),cardMap.backward(selected!!))
            }
            else{
                println("no selected cards")
            }
        }
    }
    private val call = Button(
        width = 300, height = 50, posX = 1500, posY = 910,
        text = "Call",
        font = Font(size = 24)
    ).apply {
        visual = ColorVisual(200, 91, 60)
        onMouseClicked = {
            rootService.playerService.call()
        }
    }
    private val pass = Button(
        width = 300, height = 50, posX = 1500, posY = 965,
        text = "Pass",
        font = Font(size = 24)
    ).apply {
        visual = ColorVisual(128, 128, 128)
        onMouseClicked = {
            rootService.playerService.pass()
        }
    }
    private val yourScore = Label(
        width = 300, height = 50, posX = 750, posY = 750,
        text = "",
        font = Font(size = 26)
    )
    private val pileLabel = Label(
        width = 50, height = 20, posX = 20, posY = 820,
        text = "",
        font = Font(size = 26)
    )
    private fun initScore(){
        yourScore.text = "your Score:${rootService.playerService.calculatePoints(rootService.currentGame.currentPlayer)}"
    }
    private fun updatePileCount(){
        pileLabel.text = "${rootService.currentGame.drawPile.cards.size}"
    }
    /**
    private fun displayOtherPlayers() = when(rootService.currentGame.players.size) {
        2 -> {
            hand1.isVisible = true
        }
        3 -> {

        }
        4 -> {

        }
    }
    */

    private val cardMap: BidirectionalMap<Card, CardView> = BidirectionalMap()

    init {
        background = ColorVisual(108, 168, 59)
        addComponents(swapAll, swapOne, call, pass, yourScore, tableCards, currentPlayerCards,pile,pileLabel,name1,name2,name3)
    }

    override fun refreshAfterStartGame() {
        cardMap.clear()
        val cardImageLoader = CardImageLoader()
        initializeDeckView(rootService.currentGame.tableDeck,tableCards,cardImageLoader)
        addCardListeners(tableCards)

        initializeDeckView(rootService.currentGame.currentPlayer.playerHand,currentPlayerCards,cardImageLoader)
        addCardListeners(currentPlayerCards)


        initScore()
        updatePileCount()
        name1.text = rootService.currentGame.players[0].name
        name2.text = rootService.currentGame.players[1].name

    }

    override fun refreshAfterPlayerChange() {
        cardMap.clear()
        val cardImageLoader = CardImageLoader()
        initializeDeckView(rootService.currentGame.tableDeck,tableCards,cardImageLoader)
        addCardListeners(tableCards)

        initializeDeckView(rootService.currentGame.currentPlayer.playerHand,currentPlayerCards,cardImageLoader)
        addCardListeners(currentPlayerCards)

        wanted = null
        selected = null

        initScore()
        updatePileCount()

    }

    /**
     * clears [gameComponentContainer], adds a new [CardView] for each
     * element of [Deck] onto it, and adds the newly created view/card pair
     * to the global [cardMap].
     */
    private fun initializeDeckView(
        deck: Deck,
        gameComponentContainer: GameComponentContainer<CardView>,
        cardImageLoader: CardImageLoader,show :Boolean = true
    ) {
        gameComponentContainer.clear()
        deck.cards.reversed().forEach { card ->
            val cardView = CardView(
                height = 220,
                width = 150,
                front = ImageVisual(cardImageLoader.frontImageFor(card.suit, card.value)),
                back = ImageVisual(cardImageLoader.backImage)
            )
            gameComponentContainer.add(cardView)
            cardMap.add(card to cardView)
            if(show){
                cardView.showFront()
            }
        }
    }



    private fun addCardListeners(linearLayout: LinearLayout<CardView>) {
        linearLayout.forEach{ it ->
            it.apply {
                onMouseClicked = {
                    if(tableCards.contains(this)){
                        if (wanted == this){
                            posY = 0.0
                            wanted = null
                        }
                        else{
                            tableCards.forEach{jt -> jt.apply { posY = 0.0 }}
                            posY = -20.0
                            wanted = this
                        }
                    }
                    if (currentPlayerCards.contains(this)){
                        if (selected == this){
                            posY = 0.0
                            selected = null
                        }else{
                            currentPlayerCards.forEach{jt -> jt.apply { posY = 0.0 }}
                            posY = -20.0
                            selected = this
                        }
                    }
                }
            }
        }
    }
}