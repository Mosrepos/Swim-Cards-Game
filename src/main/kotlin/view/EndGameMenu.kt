package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class EndGameMenu(rootService: RootService):Refreshable,MenuScene(400,500) {

    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "Results:",
        font = Font(size = 40)
    )
    private val result1 = Label(
        width = 300, height = 50, posX = 50, posY = 100,
        //text = "first place : ${rootService.playerService.calculatePoints()}",
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

    init {
        opacity = 1.0
        addComponents(quitButton,startNewGameButton,headlineLabel)
    }
}