package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font

class StartGameMenu(private val rootService : RootService) :Refreshable, MenuScene(500,500){

    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "New Game",
        font = Font(size = 22)
    )
}