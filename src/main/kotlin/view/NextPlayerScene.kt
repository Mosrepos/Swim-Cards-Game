package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class NextPlayerScene(rootService: RootService) :Refreshable,MenuScene(200,200){
    private var nextPlayerName = rootService.currentGame.players[1].name
    private val readyButton = Button(
        width = 140, height = 35, posX = 200, posY = 450,
        text = "Ready"
    ).apply {
        visual = ColorVisual(2, 192, 44)
    }
    private val next = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "$nextPlayerName you're next!",
        font = Font(size = 40)
    )
    init {
        addComponents(readyButton,next)
    }
}