package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

/**
 * [NextPlayerScene] is the scene that shows up when the player chose an action
 *
 * it receives the [rootService]
 * @param[rootService] is the service that connects to the entity layer
 */
class NextPlayerScene(private val rootService: RootService) :Refreshable,MenuScene(600,500){

    val readyButton = Button(
        width = 140, height = 35, posX = 200, posY = 250,
        text = "Ready"
    ).apply {
        visual = ColorVisual(2, 192, 44)
    }
    private val next = Label(
        width = 300, height = 50, posX = 50, posY = 50,
        text = "",
        font = Font(size = 32)
    )
    init {
        addComponents(readyButton,next)
    }

    override fun refreshAfterPlayerChange() {
        next.text = "${rootService.currentGame.currentPlayer.name}:you're next"
    }
}