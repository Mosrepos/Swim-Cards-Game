package view

import service.RootService
import tools.aqua.bgw.core.BoardGameScene
import tools.aqua.bgw.visual.ColorVisual

class SwimScene(private val rootService: RootService):Refreshable, BoardGameScene(1920, 1080) {
    init {
        // dark green for "Casino table" flair
        background = ColorVisual(108, 168, 59)
    }
}