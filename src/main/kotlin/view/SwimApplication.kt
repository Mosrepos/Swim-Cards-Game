package view

import service.RootService
import tools.aqua.bgw.core.BoardGameApplication

/**
 * [SwimApplication] implements all the scenes of the game
 */
class SwimApplication : Refreshable,BoardGameApplication("Swim Game"){
    // Central service from which all others are created/accessed
    // also holds the currently active game
    private val rootService = RootService()

    // Scenes

    // This is where the actual game takes place
    private val gameScene = SwimScene(rootService)

    // This menu scene is shown after application start and if the "new game" button
    // is clicked in the resultsMenu

    private val resultsMenu = EndGameMenu(rootService).apply {
        startNewGameButton.onMouseClicked = {
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

    private val nextPlayerScene = NextPlayerScene(rootService).apply {
        readyButton.onMouseClicked = {
            hideMenuScene()
        }
    }


    init {
        rootService.addRefreshables(
            this,
            gameScene,
            resultsMenu,
            startGameMenu,
            nextPlayerScene
        )

        this.showGameScene(gameScene)
        this.showMenuScene(resultsMenu)
        this.showMenuScene(startGameMenu)
    }

    override fun refreshAfterStartGame() {
        this.hideMenuScene()
    }

    override fun refreshAfterPlayerChange() {
        this.showMenuScene(nextPlayerScene)
    }

    override fun refreshAfterEndGame() {
        this.showMenuScene(resultsMenu)
    }

}