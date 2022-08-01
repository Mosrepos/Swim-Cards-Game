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

    private val startGameMenu = StartGameMenu(rootService).apply {
        quitButton.onMouseClicked = {
            exit()
        }
    }

    init {

        // all scenes and the application itself need too
        // react to changes done in the service layer
        rootService.addRefreshables(
            this,
            gameScene,
            startGameMenu
        )

        // This is just done so that the blurred background when showing
        // the new game menu has content and looks nicer
        rootService.swimService.createGame(listOf("Alice","Bob"))

        this.showGameScene(gameScene)
        this.showMenuScene(startGameMenu, 0)

    }

}