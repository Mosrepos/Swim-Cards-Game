package view

import entity.Player
import service.RootService
import tools.aqua.bgw.components.uicomponents.Button
import tools.aqua.bgw.components.uicomponents.Label
import tools.aqua.bgw.components.uicomponents.ListView
import tools.aqua.bgw.core.MenuScene
import tools.aqua.bgw.util.Font
import tools.aqua.bgw.visual.ColorVisual

/**
 * [EndGameMenu] receives the [rootService] and shows the results at the end
 *
 * @param [rootService] is the service that connects to the entity layer
 */
class EndGameMenu(private val rootService: RootService) : Refreshable, MenuScene(400, 500) {

    private val headlineLabel = Label(width = 300, height = 50, posX = 50, posY = 50, text = "Results:", font = Font(size = 40))

    val quitButton = Button(width = 140, height = 35, posX = 50, posY = 450, text = "Quit").apply {
        visual = ColorVisual(255, 91, 91)
    }

    val startNewGameButton = Button(width = 140, height = 35, posX = 200, posY = 450, text = "Start new game").apply {
        visual = ColorVisual(2, 192, 44)
    }

    //list to view the numbers in the left column
    private val allResults = ListView(250, 150, 100, 250, listOf<String>(), Font(26))
    //list to view the names in the left column
    private val allNames = ListView(50, 150, 200, 250, listOf<String>(), Font(26))


    /**
     * fun to calculate the results of the [players]
     *
     * @param[players] is the list of the players
     */
    private fun showResults (players : List<Player>){
        val results = players.map { it to rootService.playerService.calculatePoints(it) }.sortedBy { it.second }

        val names = results.map { it.first.name }.reversed()
        val scores = results.map { it.second.toString() }.reversed()
        allResults.items.setAll(scores)
        allNames.items.setAll(names)
    }


    override fun refreshAfterEndGame() {
        showResults(rootService.currentGame.players)
    }

    init {
        opacity = 1.0
        addComponents(quitButton, startNewGameButton, headlineLabel,allNames,allResults)
    }
}

