package view

import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

class SwimScene(private val rootService: RootService):Refreshable, BoardGameScene(1920, 1080) {

    /**
    private fun displayOtherPlayers{

    }
    */

    val swapAll = Button(
        width = 300, height = 50, posX = 1600, posY = 800,
        text = "Swap All Cards"
    ).apply {
        visual = ColorVisual(0, 255, 0)
    }
    val swapOne = Button(
        width = 300, height = 50, posX = 1600, posY = 855,
        text = "Swap One Card"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }
    val call = Button(
        width = 300, height = 50, posX = 1600, posY = 910,
        text = "Call"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }
    val pass = Button(
        width = 300, height = 50, posX = 1600, posY = 965,
        text = "Pass"
    ).apply {
        visual = ColorVisual(255, 91, 91)
    }
    //private var scoreOfCurrentPlayer = rootService.playerService.calculatePoints()
    private val yourScore = Label(
        width = 300, height = 50, posX = 800, posY = 700,
        //text = "your Score:" + scoreOfCurrentPlayer,
        font = Font(size = 22)
    )
    init {
        background = ColorVisual(108, 168, 59)
        addComponents(swapAll,swapOne,call,pass,yourScore)
    }
}