package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.visual.ColorVisual

class EndGameMenu(rootService: RootService):Refreshable,MenuScene(400,500) {
    val quitButton = Button(
        width = 140, height = 35,
        posX = 50, posY = 450,
        text = "Quit"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }

    val startButton = Button(
        width = 140, height = 35,
        posX = 200, posY = 450,
        text = "Start"
    ).apply {
        visual = ColorVisual(2, 192, 44)
    }
}