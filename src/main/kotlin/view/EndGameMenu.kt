package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.components.uicomponents.ListView
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class EndGameMenu(private val rootService: RootService) : Refreshable, MenuScene(400, 500) {

    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "Results:",
        font = Font(size = 40)
    )

    val quitButton = Button(
        width = 140, height = 35,
        posX = 50, posY = 450,
        text = "Quit"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }

    val startNewGameButton = Button(
        width = 140, height = 35,
        posX = 200, posY = 450,
        text = "Start new game"
    ).apply {
        visual = ColorVisual(2, 192, 44)
    }

    val players = rootService.currentGame.players
    var results = listOf(players.forEach { rootService.playerService.calculatePoints(it) })
    private val allResults = ListView(50, 150, 300, 250, results, Font(32))

    override fun refreshAfterEndGame() {
    }

    init {
        opacity = 1.0
        addComponents(quitButton, startNewGameButton, headlineLabel,allResults)
    }
}