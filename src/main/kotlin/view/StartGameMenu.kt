package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.components.uicomponents.TextField
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class StartGameMenu(private val rootService: RootService) : Refreshable, MenuScene(400, 500) {

    private val headlineLabel = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "New Game",
        font = Font(size = 40)
    )
    private val p1Input: TextField = TextField(
        width = 200, height = 35, posX = 100, posY = 125,
        text = "Player 1"
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = this.text.isBlank() || p2Input.text.isBlank()
        }
    }

    private val p2Input: TextField = TextField(
        width = 200, height = 35, posX = 100, posY = 175,
        text = "Player 2"
    ).apply {
        onKeyTyped = {
            startButton.isDisabled = p1Input.text.isBlank() || this.text.isBlank()
        }
    }

    private val p3Input: TextField = TextField(
        width = 200, height = 35, posX = 100, posY = 225,
        text = ""
    )

    private val p4Input: TextField = TextField(
        width = 200, height = 35, posX = 100, posY = 275,
        text = ""
    )


    val quitButton = Button(
        width = 140, height = 35, posX = 50, posY = 450,
        text = "Quit"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }

    val startButton = Button(
        width = 140, height = 35, posX = 200, posY = 450,
        text = "Start"
    ).apply {
        visual = ColorVisual(2, 192, 44)
        onMouseClicked = {
            rootService.swimService.createGame(
                listOf(p1Input.text.trim(), p2Input.text.trim(),p3Input.text.trim(),p4Input.text.trim())
            )
            rootService.swimService.startGame()
        }
    }

    val rulesButton = Button(
        width = 140, height = 35, posX = 120, posY = 400,
        text = "Rules"
    ).apply {
        visual = ColorVisual(234, 216, 56)
    }

    init {
        opacity = 1.0
        addComponents(headlineLabel,quitButton, startButton, rulesButton, p1Input,p2Input, p3Input, p4Input)
    }
}