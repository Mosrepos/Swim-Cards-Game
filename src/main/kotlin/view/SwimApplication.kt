package view

import service.RootService
import tools.aqua.bgw.core.BoardGameApplication

class SwimApplication : Refreshable,BoardGameApplication("Swim Game"){
    // Central service from which all others are created/accessed
    // also holds the currently active game
    private val rootService = RootService()

    // Scenes

    // This is where the actual game takes place
    private val gameScene = SwimScene(rootService)

    // This menu scene is shown after application start and if the "new game" button
    // is clicked in the gameFinishedMenuScene

    private val resultsMenu = EndGameMenu(rootService).apply {
        startButton.onMouseClicked = {
            this@SwimApplication.showMenuScene(startGameMenu)
        }
        quitButton.onMouseClicked = {
            exit()
        }
    }
    private val startGameMenu = StartGameMenu(rootService).apply {
        quitButton.onMouseClicked = {
            exit()
        }
    }
    //this scene shows the rules
    private val rulesScene = StartGameMenu(rootService).apply {
        rulesButton.onMouseClicked = {
            RulesScene()
        }
    }

    init {

        // all scenes and the application itself need to
        // react to changes done in the service layer
        rootService.addRefreshables(
            this,
            gameScene,
            resultsMenu,
            startGameMenu
        )

        // This is just done so that the blurred background when showing
        // the new game menu has content and looks nicer
        rootService.swimService.createGame(listOf("Alice","Bob"))

        this.showMenuScene(rulesScene)
        this.showGameScene(gameScene)
        this.showMenuScene(resultsMenu)
        this.showMenuScene(startGameMenu)
    }

    override fun refreshAfterStartGame() {
        this.hideMenuScene()
    }

    override fun refreshAfterEndGame() {
        this.showMenuScene(resultsMenu,0)
    }

}